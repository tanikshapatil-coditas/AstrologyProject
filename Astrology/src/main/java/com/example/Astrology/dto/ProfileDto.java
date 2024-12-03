package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfileDto {
    private String username;
    private String fullName;
    private String emailId;
    private String phoneNumber;
    private String bio;
    private int yearsOfExperience;

    public ProfileDto() {

    }
}
