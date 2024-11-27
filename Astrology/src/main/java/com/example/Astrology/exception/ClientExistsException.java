package com.example.Astrology.exception;

public class ClientExistsException extends RuntimeException {
    public ClientExistsException() {
        super(ExceptionConstants.USERNAME_EXISTS);
    }
}
