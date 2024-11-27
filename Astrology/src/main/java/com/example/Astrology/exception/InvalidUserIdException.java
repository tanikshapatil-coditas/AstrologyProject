package com.example.Astrology.exception;

public class InvalidUserIdException extends RuntimeException {
    public InvalidUserIdException() {
        super(ExceptionConstants.INVALID_USER_ID);
    }
}
