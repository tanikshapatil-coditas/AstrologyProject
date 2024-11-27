package com.example.Astrology.exception;

public class UsernameRequiredException extends RuntimeException {
    public UsernameRequiredException() {
        super(ExceptionConstants.USERNAME_REQUIRED);
    }
}
