package com.example.Astrology.exception;

public class ConsultationNotFoundException extends RuntimeException {
    public ConsultationNotFoundException() {
        super(ExceptionConstants.CONSULTATION_NOT_FOUND);
    }
}
