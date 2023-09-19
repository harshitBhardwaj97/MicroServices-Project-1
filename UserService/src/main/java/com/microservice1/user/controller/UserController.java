package com.microservice1.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice1.user.model.User;
import com.microservice1.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);		
	}

}
