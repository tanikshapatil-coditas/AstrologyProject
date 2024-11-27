//package com.example.Astrology.service;
//
//import com.example.Astrology.dto.AuthRequest;
//import com.example.Astrology.dto.AuthResponse;
//
///**
// * Service interface for authentication-related operations, including
// * verifying user credentials and refreshing JWT tokens.
// */
//public interface AuthService {
//
//    /**
//     * Verifies the user's credentials and generates an authentication response.
//     *
//     * @param request The request containing the user's login credentials, such as username and password.
//     * @return An AuthResponse object containing the authentication result,
//     * such as the generated JWT token and any additional information.
//     */
//    AuthResponse verify(AuthRequest request);
//
//    /**
//     * Refreshes the JWT token using a valid refresh token.
//     *
//     * @param refreshToken The refresh token used to generate a new JWT token.
//     * @return A new JWT token as a String, generated based on the provided refresh token.
//     */
//    String refresh(String refreshToken);
//}
