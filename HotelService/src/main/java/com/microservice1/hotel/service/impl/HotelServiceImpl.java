package com.microservice1.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice1.hotel.exception.ResourceNotFoundException;
import com.microservice1.hotel.model.Hotel;
import com.microservice1.hotel.repository.HotelRepository;
import com.microservice1.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found with hotel id "+hotelId));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

}
