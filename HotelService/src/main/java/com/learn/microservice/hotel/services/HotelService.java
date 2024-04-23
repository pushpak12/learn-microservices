package com.learn.microservice.hotel.services;

import java.util.List;

import com.learn.microservice.hotel.entities.Hotel;

public interface HotelService {

	// create
	Hotel create(Hotel hotel);
	
	// get all
	List<Hotel> getAll();
	
	// get single
	Hotel get(String id);
	
}
