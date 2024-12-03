package com.example.Astrology.service.impl;

import com.example.Astrology.dto.AuthRequest;
import com.example.Astrology.dto.AuthResponse;
import com.example.Astrology.entity.Astrologer;
import com.example.Astrology.entity.RefreshToken;
import com.example.Astrology.exception.InvalidUserIdException;
import com.example.Astrology.exception.RefreshTokenNotFoundException;
import com.example.Astrology.repository.RefreshTokenRepository;
import com.example.Astrology.repository.AstrologyRepository;
import com.example.Astrology.service.AuthService;
import com.example.Astrology.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation that handles authentication-related operations such as user login,
 * token generation, and refresh token management.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RefreshTokenRepository refreshrepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private AstrologyRepository astrologyRepository;

    /**
     * Verifies user credentials, generates an access token and refresh token if authentication is successful.
     *
     * @param request The authentication request containing the username and password.
     * @return AuthResponse containing the generated access token and refresh token, or "failed" if authentication fails.
     */
    @Override
    public AuthResponse verify(AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            String accessToken = jwtService.generateToken(request.getUsername());
            RefreshToken refreshToken = jwtService.createRefreshToken(request.getUsername());
            return new AuthResponse(accessToken, refreshToken.getToken());
        }

        return new AuthResponse("failed", "failed");
    }

    /**
     * Refreshes the access token using the provided refresh token.
     *
     * @param refreshToken The refresh token to be used for generating a new access token.
     * @return The newly generated access token.
     * @throws RefreshTokenNotFoundException if the provided refresh token is invalid or expired.
     */
    @Override
    public String refresh(String refreshToken) {
        return refreshrepo.findById(refreshToken)
                .map(jwtService::verifyRefreshTokenExpiration)
                .map(RefreshToken::getUser)
                .map(username -> {
                    Astrologer astrologer = astrologyRepository.findByUsername(username.getUsername())
                            .orElseThrow(() -> new RuntimeException("User not found"));
                    return jwtService.generateToken(astrologer.getUsername());
                })
                .orElseThrow(RefreshTokenNotFoundException::new);
    }

    @Override
    public void logout(String accessToken) {
        Astrologer astrologer = astrologyRepository.findByUsername(jwtService.extractUsername(accessToken)).orElseThrow(RefreshTokenNotFoundException::new);;
    }
}
