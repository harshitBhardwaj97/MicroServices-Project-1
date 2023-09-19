package com.microservice1.rating.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource not found on server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
