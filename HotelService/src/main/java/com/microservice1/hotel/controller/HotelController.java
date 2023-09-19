package com.microservice1.hotel.controller;

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

import com.microservice1.hotel.model.Hotel;
import com.microservice1.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel savedHotel = hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(savedHotel, HttpStatus.CREATED);			
	}

	@GetMapping(path = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel fetchedHotel = hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(fetchedHotel, HttpStatus.OK);			
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotelList = hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);			
	}
	
}
