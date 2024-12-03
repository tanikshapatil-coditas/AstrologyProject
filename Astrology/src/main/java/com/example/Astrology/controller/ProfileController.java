package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.ProfileDto;
import com.example.Astrology.entity.Astrologer;
import com.example.Astrology.service.ProfileService;
import com.example.Astrology.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<ApiResponse<ProfileDto>> viewProfile(String username) {
        ProfileDto newProfile = profileService.viewProfile(username);
        return ResponseUtil.success(newProfile, "Profile viewed successfully!!");
    }
}
