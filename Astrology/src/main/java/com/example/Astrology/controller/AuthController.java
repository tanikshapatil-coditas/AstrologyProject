//package com.example.Astrology.controller;
//
//import com.example.Astrology.dto.AuthRequest;
//import com.example.Astrology.dto.AuthResponse;
//import com.example.Astrology.dto.ResponseUtil;
//import com.example.Astrology.service.AuthService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@AllArgsConstructor
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    public ResponseEntity<com.example.Astrology.dto.ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
//        AuthResponse token = authService.verify(request);
//        return ResponseUtil.success(token, "Logged In successfully!!");
//    }
//
//
//    @PostMapping("/refresh")
//    public ResponseEntity<com.example.Astrology.dto.ApiResponse<String>> refresh(@RequestHeader("Authorization") String refreshToken) {
//        String accessToken = authService.refresh(refreshToken);
//        return ResponseUtil.success(accessToken, "Access token generated successfully!!");
//    }
//
//}
