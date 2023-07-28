package com.example.user_service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not Found on Server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
