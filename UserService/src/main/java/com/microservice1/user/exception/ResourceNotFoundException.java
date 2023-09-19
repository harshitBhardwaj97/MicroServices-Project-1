package com.microservice1.user.exception;

@SuppressWarnings(value = { "serial" })
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource not found on server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}


}
