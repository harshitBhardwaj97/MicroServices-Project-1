package com.microservice1.user.service;

import java.util.List;

import com.microservice1.user.model.User;

public interface UserService {

	User getUser(String userId);
	List<User> getAllUsers();
	User createUser(User user);
	
}
