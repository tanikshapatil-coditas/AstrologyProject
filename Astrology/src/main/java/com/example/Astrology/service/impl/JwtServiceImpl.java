//package com.example.Astrology.service.impl;
//
//import com.example.Astrology.entity.Astrologer;
//import com.example.Astrology.entity.RefreshToken;
//import com.example.Astrology.repository.AstrologyRepository;
//import com.example.Astrology.repository.RefreshTokenRepository;
//import com.example.Astrology.service.JwtService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.security.NoSuchAlgorithmException;
//import java.time.Instant;
//import java.util.*;
//import java.util.function.Function;
//
///**
// * Implementation of the JwtService interface, handling JWT token generation, validation, and refresh token management.
// * Provides functionality to generate access tokens, refresh tokens, and validate tokens.
// */
//@Service
//public class JwtServiceImpl implements JwtService {
//
//    private String secretkey = "";
//
//    private final long ACCESS_TOKEN_EXPIRATION = 30 * 60 * 1000;
//
//
//    private final long REFRESH_TOKEN_EXPIRATION = 6 * 30 * 24 * 60 * 60 * 1000L;
//
//    @Autowired
//    private AstrologyRepository astrologyRepository;
//
//
//
//    @Autowired
//    private RefreshTokenRepository refreshTokenRepository;
//
//    /**
//     * Initializes the JwtServiceImpl by generating a secret key for signing JWTs.
//     */
//    public JwtServiceImpl() {
//        try {
//            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
//            SecretKey sk = keyGen.generateKey();
//            secretkey = Base64.getEncoder().encodeToString(sk.getEncoded());
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Generates a JWT token for the given username.
//     *
//     * @param username The username for which the token is being generated.
//     * @return The generated JWT token as a string.
//     */
//    @Override
//    public String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        return Jwts.builder()
//                .claims(claims)
//                .subject(username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
//                .signWith(getKey())
//                .compact();
//    }
//
//    /**
//     * Creates a refresh token for the specified username.
//     *
//     * @param username The username for which the refresh token is being created.
//     * @return The created RefreshToken object.
//     */
//    @Override
//    public RefreshToken createRefreshToken(String username) {
//        Optional<Astrologer> astrologer = astrologyRepository.findByUsername(username);
//        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByUserId(astrologer.get().getId());
//        if(refreshToken.isPresent()){
//            return refreshToken.get();
//        }
//        else{
//            RefreshToken refreshToken1 = RefreshToken.builder()
//                    .user(astrologyRepository.findByUsername(username).get())
//                    .token(UUID.randomUUID().toString())
//                    .expiryDate(Instant.now().plusMillis(REFRESH_TOKEN_EXPIRATION))
//                    .build();
//            return refreshTokenRepository.save(refreshToken1);
//        }
//
//    }
//
//    /**
//     * Validates the given JWT token by checking its expiration and ensuring the username matches.
//     *
//     * @param token       The JWT token to validate.
//     * @param userDetails The user details to match the token against.
//     * @return true if the token is valid, false otherwise.
//     */
//    @Override
//    public boolean validateToken(String token, UserDetails userDetails) {
//        final String userName = extractUsername(token);
//        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    /**
//     * Extracts the username from the given JWT token.
//     *
//     * @param token The JWT token from which the username will be extracted.
//     * @return The username extracted from the token.
//     */
//    @Override
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    /**
//     * Verifies if a refresh token has expired. If expired, it deletes the token from the repository.
//     *
//     * @param token The refresh token to verify.
//     * @return The refresh token if it is still valid.
//     * @throws RuntimeException if the token is expired.
//     */
//    @Override
//    public RefreshToken verifyRefreshTokenExpiration(RefreshToken token) {
//        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
//            refreshTokenRepository.delete(token);
//            throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
//        }
//        return token;
//    }
//
//    /**
//     * Checks if the JWT token has expired.
//     *
//     * @param token The JWT token to check.
//     * @return true if the token has expired, false otherwise.
//     */
//    @Override
//    public boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    /**
//     * Retrieves the SecretKey used for signing the JWT tokens.
//     *
//     * @return The SecretKey for signing JWTs.
//     */
//    private SecretKey getKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    /**
//     * Extracts a specific claim from the JWT token.
//     *
//     * @param token         The JWT token to extract the claim from.
//     * @param claimResolver The function to extract the desired claim.
//     * @param <T>           The type of the claim.
//     * @return The extracted claim value.
//     */
//    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//
//    /**
//     * Extracts all claims from the JWT token.
//     *
//     * @param token The JWT token to extract the claims from.
//     * @return The claims extracted from the token.
//     */
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    /**
//     * Extracts the expiration date of the JWT token.
//     *
//     * @param token The JWT token to extract the expiration date from.
//     * @return The expiration date of the token.
//     */
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//}
