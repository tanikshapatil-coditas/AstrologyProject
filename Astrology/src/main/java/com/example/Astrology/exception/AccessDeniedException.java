package com.example.Astrology.exception;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException() {
        super(ExceptionConstants.ACCESS_DENIED);
    }
}
