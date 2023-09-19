package com.microservice1.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice1.rating.model.Rating;
import com.microservice1.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = ratingService.createRating(rating);
		return new ResponseEntity<Rating>(createdRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
		Rating fetchedRating = ratingService.getRating(ratingId);
		return new ResponseEntity<Rating>(fetchedRating,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratingList = ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratingList,HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
		List<Rating> ratingListByUserId = ratingService.getAllRatingsByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingListByUserId,HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
		List<Rating> ratingListByHotelId = ratingService.getAllRatingsByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingListByHotelId,HttpStatus.OK);
	}

	
}
