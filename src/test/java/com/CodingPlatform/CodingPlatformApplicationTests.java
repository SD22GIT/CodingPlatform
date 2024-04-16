package com.CodingPlatform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.CodingPlatform.Entity.User;
import com.CodingPlatform.Exception.UserAlreadyExistsException;
import com.CodingPlatform.Exception.UserDoesNotExistsException;
import com.CodingPlatform.Service.CodingPlatformService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CodingPlatformApplicationTests {

	@Autowired
	private CodingPlatformService service;

	@Test
	public void testGetAllUsers() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);
		int users = service.getAllUsers().size();
		assertTrue(users >= 1);
	}

	@Test
	public void testGetUserById() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);
		User u = service.findUserById(10);
		assertEquals(10, u.getUserId());
	}

	@Test
	public void testAddUser() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);
		User u = service.findUserById(10);
		assertEquals(10, u.getUserId());
	}

	@Test
	public void testAddExistingUser() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);

		UserAlreadyExistsException exception = assertThrows(UserAlreadyExistsException.class, () -> {
			service.addUser(u1);
		});

		assertEquals("User Already Exists", exception.getMessage());

	}

	@Test
	public void testUpdateUserScore() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);

		service.updateUserScore(10, 10);
		service.updateUserScore(100, 10);
		service.updateUserScore(90, 10);
		User updatedUser = service.findUserById(10);

		assertTrue(updatedUser.getBadges().size() == 2);
		assertTrue(updatedUser.getBadges().contains("Code Ninja"));
		assertTrue(updatedUser.getBadges().contains("Code Master"));
		assertFalse(updatedUser.getBadges().contains("Code Champ"));
	}

	@Test
	public void testDeleteUserById() {
		User u1 = new User(10, "User1", 0, null);
		service.deleteUserById(10);
		service.addUser(u1);
		service.deleteUserById(10);

		UserDoesNotExistsException exception = assertThrows(UserDoesNotExistsException.class, () -> {
			service.findUserById(10);
		});
		assertEquals("User Does Not Exist", exception.getMessage());

	}

	@AfterEach
	public void removeTestCaseUser() {
		service.deleteUserById(10);
	}

}
