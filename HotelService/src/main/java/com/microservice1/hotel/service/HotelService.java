package com.microservice1.hotel.service;

import java.util.List;

import com.microservice1.hotel.model.Hotel;

public interface HotelService {

	Hotel getHotel(String hotelId);
	List<Hotel> getAllHotels();
	Hotel createHotel(Hotel hotel);
	
}
