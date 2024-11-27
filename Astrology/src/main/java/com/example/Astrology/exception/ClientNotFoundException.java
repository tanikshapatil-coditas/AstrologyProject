package com.example.Astrology.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super(ExceptionConstants.CLIENT_NOT_FOUND);
    }

}
