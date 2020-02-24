package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("ClientTrackingApplication/user")
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/{userName}/{password}/")
	public ResponseEntity<User> isValidUser(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		if (service.isValidUser(userName, password)) {
			return new ResponseEntity<User>(HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if (service.isValidUser(user.getUserName(), user.getPassword())) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			service.addUser(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}
}
