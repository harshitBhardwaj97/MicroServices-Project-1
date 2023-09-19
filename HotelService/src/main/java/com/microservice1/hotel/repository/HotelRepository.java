package com.microservice1.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice1.hotel.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
