package com.microservice1.rating.service;

import java.util.List;

import com.microservice1.rating.model.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	Rating getRating(String ratingId);
	List<Rating> getAllRatings();
	List<Rating> getAllRatingsByUserId(String userId);
	List<Rating> getAllRatingsByHotelId(String hotelId);

}
