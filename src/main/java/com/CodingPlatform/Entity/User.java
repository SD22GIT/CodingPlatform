package com.CodingPlatform.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

	@Id
	private int userId;
	private String username;
	private int score;
	private List<String> badges;

	public User() {
		super();
	}

	public User(int userId, String username, int score, List<String> badges) {
		super();
		this.userId = userId;
		this.username = username;
		this.score = score;
		this.badges = badges;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getBadges() {
		return badges;
	}

	public void setBadges(List<String> badges) {
		this.badges = badges;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", score=" + score + ", badges=" + badges + "]";
	}

}
