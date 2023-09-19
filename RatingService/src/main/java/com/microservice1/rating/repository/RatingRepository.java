package com.microservice1.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice1.rating.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findAllByHotelId(String hotelId);
	List<Rating> findAllByUserId(String userId);
}
