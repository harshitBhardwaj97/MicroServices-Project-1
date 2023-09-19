package com.microservice1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice1.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException resourceNotFoundException){
		String message = resourceNotFoundException.getMessage();
		var apiResponse = ApiResponse.builder().message(message).successStatus(true)
				.httpStatus(HttpStatus.NOT_FOUND)				
				.build();
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
}
