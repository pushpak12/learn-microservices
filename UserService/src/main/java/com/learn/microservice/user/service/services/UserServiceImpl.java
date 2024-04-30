package com.learn.microservice.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.microservice.user.service.entities.Hotel;
import com.learn.microservice.user.service.entities.Rating;
import com.learn.microservice.user.service.entities.User;
import com.learn.microservice.user.service.exceptions.ResourceNotFoundException;
import com.learn.microservice.user.service.external.services.HotelService;
import com.learn.microservice.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		// get user from database with the help of repository
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found "+userId));
		// fetch rating of the above user from RATING SERVICE
		// http://localhost:8083/ratings/users/5b95938a-3d37-4948-a4ce-196c5124086e
		
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		logger.info("{}", ratings);
		
		List<Rating> ratingList =  ratings.stream().map(rating -> {
			// api call to Hotel Service to get the hotel
			// http://localhost:8082/hotels/d7d0d468-422e-4147-9174-915f46ba2c2c
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
//			logger.info("response status code",forEntity.getStatusCode());
			
			// set hotel to rating
			rating.setHotel(hotel);
			
			// return rating
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratings);
		return user;
	}

}
