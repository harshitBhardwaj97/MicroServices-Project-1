package com.microservice1.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice1.rating.exception.ResourceNotFoundException;
import com.microservice1.rating.model.Rating;
import com.microservice1.rating.repository.RatingRepository;
import com.microservice1.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public Rating getRating(String ratingId) {
		return ratingRepository.findById(ratingId)
		.orElseThrow(()-> new ResourceNotFoundException("Rating not found with id "+ratingId));
		
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		return ratingRepository.findAllByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		return ratingRepository.findAllByHotelId(hotelId);
	}

}
