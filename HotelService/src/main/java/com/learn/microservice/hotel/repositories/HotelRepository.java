package com.learn.microservice.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservice.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
