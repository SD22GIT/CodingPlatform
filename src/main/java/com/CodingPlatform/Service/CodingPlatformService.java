package com.CodingPlatform.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingPlatform.Entity.User;
import com.CodingPlatform.Exception.InvalidScoreException;
import com.CodingPlatform.Exception.UserAlreadyExistsException;
import com.CodingPlatform.Exception.UserDoesNotExistsException;
import com.CodingPlatform.Repository.CodingPlatformRepository;

@Service
public class CodingPlatformService {

	@Autowired
	private CodingPlatformRepository repository;

	public List<User> getAllUsers() {
		List<User> users = repository.findAll();

		Collections.sort(users, new Comparator<User>() {
			public int compare(User user1, User user2) {
				return user1.getScore() - user2.getScore();
			}
		});

		return users;
	}

	public User findUserById(int id) {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			throw new UserDoesNotExistsException("User Does Not Exist");
		}
	}

	public User addUser(User user) {
		if (checkIfUserAlreadyExists(user)) {
			throw new UserAlreadyExistsException("User Already Exists");
		}
		user.setBadges(null);
		user.setScore(0);
		return repository.save(user);
	}

	public User updateUserScore(int score, int id) {
		User user = findUserById(id);
		if (score < 0) {
			throw new InvalidScoreException("Score cannot be less than 0");
		}

		if (score > 100) {
			throw new InvalidScoreException("Score cannot be greater than 100");
		}
		user.setScore(score);
		List<String> badges = user.getBadges();
		if (badges == null) {
			badges = new ArrayList<String>();
			user.setBadges(badges);
		}
		String badge = null;
		if (score < 30) {
			badge = "Code Ninja";
		} else if (score < 60) {
			badge = "Code Champ";
		} else {
			badge = "Code Master";
		}

		if (!checkIfBadgePresent(badges, badge)) {
			badges.add(badge);
		}

		return repository.save(user);
	}

	public void deleteUserById(int id) {
		repository.deleteById(id);

	}

	public void deleteAllUser() {
		repository.deleteAll();
	}

	private boolean checkIfBadgePresent(List<String> badges, String badgeToCheck) {
		for (String badge : badges) {
			if (badgeToCheck.equalsIgnoreCase(badge)) {
				return true;
			}
		}

		return false;
	}

	private boolean checkIfUserAlreadyExists(User user) {
		try {
			findUserById(user.getUserId());
		} catch (UserDoesNotExistsException ex) {
			return false;
		}

		return true;
	}

}
