package com.learn.microservice.user.service.services;

import java.util.List;

import com.learn.microservice.user.service.entities.User;

public interface UserService {

	// user operations

	// create
	User saveUser(User user);

	// get all users
	List<User> getAllUsers();

	// get single user with userId
	User getUser(String userId);
}
