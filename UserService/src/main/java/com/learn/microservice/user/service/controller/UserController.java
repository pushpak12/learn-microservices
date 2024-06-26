package com.learn.microservice.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservice.user.service.entities.User;
import com.learn.microservice.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// create
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User _user = userService.saveUser(user);
		return new ResponseEntity<User>(_user, HttpStatus.OK);
	}
	// single user get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.OK);
	}
	
	// all user get
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
}
