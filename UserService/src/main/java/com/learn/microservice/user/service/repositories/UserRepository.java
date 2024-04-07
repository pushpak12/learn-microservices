package com.learn.microservice.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservice.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
}
