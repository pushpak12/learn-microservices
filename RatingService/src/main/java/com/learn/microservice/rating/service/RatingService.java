package com.learn.microservice.rating.service;

import java.util.List;

import com.learn.microservice.rating.entities.Rating;

public interface RatingService {

	// create
	Rating create(Rating rating);
	
	// get all ratings
	List<Rating> getratings();
	
	// get all rating by user
	List<Rating> getRatingByUserId(String userId);
	
	// get all ratings by hotel
	List<Rating> getRatingByHotelId(String hotelId);
}
