package com.CodingPlatform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodingPlatform.Entity.User;
import com.CodingPlatform.Service.CodingPlatformService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1")
public class CodingPlatformController {

	@Autowired
	private CodingPlatformService service;

	@GetMapping("/users")
	public List<User> getUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		return service.findUserById(userId);
	}

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return service.addUser(user);
	}

	@PutMapping("/users/{userId}")
	public User updateUserScore(@RequestBody Integer score, @PathVariable int userId) {
		return service.updateUserScore(score, userId);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		service.deleteUserById(userId);
	}

}
