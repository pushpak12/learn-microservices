package com.learn.microservice.hotel.exceptions;

import org.springframework.stereotype.Service;


public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException() {
		super("Resource not found");
	}
}
