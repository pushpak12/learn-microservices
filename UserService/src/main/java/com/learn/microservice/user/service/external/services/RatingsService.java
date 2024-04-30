package com.learn.microservice.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.learn.microservice.user.service.entities.Rating;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingsService {
	
	// get
	
	// post
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	
	
	// put
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingId, Rating values);
	
	// delete 
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable(name="ratingId") String ratingId);
	
}
