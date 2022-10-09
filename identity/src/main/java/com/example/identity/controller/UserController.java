package com.example.identity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.identity.entities.UserDto;
import com.example.identity.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/{username}")
	public UserDto getUser(@PathVariable("username") String username) {
		return userService.loadUserByUsername(username);
	}

}
