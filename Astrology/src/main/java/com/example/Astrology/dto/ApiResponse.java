package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private int status;
    private String message;
    private Instant timeStamp;

    public ApiResponse() {
    }

    public ApiResponse(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.timeStamp = Instant.now();
    }
}
