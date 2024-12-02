package com.example.Astrology.util;

import com.example.Astrology.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(data, HttpStatus.OK.value(), message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> delete(T data,String message){
        ApiResponse<T> response = new ApiResponse<>(data,HttpStatus.NO_CONTENT.value(),message);
        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(T data, String message, HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<>(data, status.value(), message);
        return new ResponseEntity<>(response, status);
    }
}
