package com.example.Astrology.exceptionHandler;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
