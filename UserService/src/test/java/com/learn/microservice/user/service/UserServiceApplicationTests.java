package com.learn.microservice.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.microservice.user.service.external.services.RatingsService;
import com.learn.microservice.user.service.entities.Rating;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingsService ratingService;
	
//	@Test
//	void createrating() {
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
//		Rating savedRating = ratingService.createRating(rating);
//		
//		System.out.println("new rating created");
//	}

}
