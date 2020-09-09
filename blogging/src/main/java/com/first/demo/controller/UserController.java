package com.first.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.model.UserData;
import com.first.demo.repository.UsersRepository;


@RestController
public class UserController {

	@Autowired
	private UsersRepository userRepository;
	
	@GetMapping(name="user/find")
	public UserData getUser() {
		return userRepository.findByName("jjj");
	}
	
	@PostMapping(name = "/user/create")
	public UserData createUser(@Validated @RequestBody UserData user) {
		userRepository.save(user);
		return user;
	}
}
