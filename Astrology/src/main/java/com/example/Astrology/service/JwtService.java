//package com.example.Astrology.service;
//
//import com.example.Astrology.entity.RefreshToken;
//import org.springframework.security.core.userdetails.UserDetails;
//
///**
// * Service interface for handling JWT (JSON Web Token) operations, such as token generation,
// * validation, and refresh token management.
// */
//public interface JwtService {
//
//    /**
//     * Generates a JWT token for a user based on their username.
//     *
//     * @param username The username of the user for whom the token is being generated.
//     * @return The generated JWT token as a String.
//     */
//    String generateToken(String username);
//
//    /**
//     * Extracts the username from a given JWT token.
//     *
//     * @param token The JWT token from which the username will be extracted.
//     * @return The username embedded within the JWT token.
//     */
//    String extractUsername(String token);
//
//    /**
//     * Validates a JWT token by checking its signature, expiration, and whether it matches
//     * the provided user details.
//     *
//     * @param token The JWT token to validate.
//     * @param userDetails The user details to compare against the token.
//     * @return True if the token is valid, otherwise false.
//     */
//    boolean validateToken(String token, UserDetails userDetails);
//
//    /**
//     * Creates a refresh token for a given user.
//     *
//     * @param username The username of the user for whom the refresh token is being created.
//     * @return The generated refresh token as a RefreshToken object.
//     */
//    RefreshToken createRefreshToken(String username);
//
//    /**
//     * Checks if a given JWT token has expired.
//     *
//     * @param token The JWT token to check.
//     * @return True if the token is expired, otherwise false.
//     */
//    boolean isTokenExpired(String token);
//
//    /**
//     * Verifies the expiration status of a refresh token.
//     *
//     * @param token The refresh token to verify.
//     * @return The provided RefreshToken object, potentially updated with expiration status.
//     */
//    RefreshToken verifyRefreshTokenExpiration(RefreshToken token);
//}
