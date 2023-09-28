package com.takeo.exceptions;

public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String s) {
        super(s);
        this.message=s;
    }
}
