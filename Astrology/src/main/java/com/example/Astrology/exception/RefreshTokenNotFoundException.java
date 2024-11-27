package com.example.Astrology.exception;

public class RefreshTokenNotFoundException extends RuntimeException {
    public RefreshTokenNotFoundException() {
        super(ExceptionConstants.REFRESH_TOKEN_NOT_FOUND);
    }
}
