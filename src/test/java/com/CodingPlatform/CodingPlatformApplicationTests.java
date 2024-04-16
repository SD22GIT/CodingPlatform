package com.CodingPlatform;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.CodingPlatform.Entity.User;
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
		User u = service.findUserById(10);
		assertEquals(10, u.getUserId());
	}

}
