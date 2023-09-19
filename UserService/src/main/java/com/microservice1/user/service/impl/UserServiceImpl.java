package com.microservice1.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice1.user.exception.ResourceNotFoundException;
import com.microservice1.user.model.User;
import com.microservice1.user.repository.UserRepository;
import com.microservice1.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with the user id : "+userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		String randomUUID = UUID.randomUUID().toString();
		user.setUserId(randomUUID);
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
