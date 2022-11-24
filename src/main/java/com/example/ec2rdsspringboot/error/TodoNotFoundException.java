package com.example.ec2rdsspringboot.error;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException() {
        super();
    }

    public TodoNotFoundException(String message) {
        super(message);
    }

    public TodoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
