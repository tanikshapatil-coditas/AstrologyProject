package com.example.Astrology.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security configuration class that sets up the necessary security mechanisms,
 * including authentication provider, session management, and JWT-based authorization.
 */
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private CustomUserDetailService userDetailsService;

    /**
     * Configures HTTP security for the application.
     * Disables CSRF, sets up endpoints for public access, and adds JWT-based authentication filter.
     * Configures session management to be stateless (no session persistence).
     *
     * @param http The HttpSecurity object used to configure web-based security
     * @return A SecurityFilterChain instance that defines the security rules for HTTP requests
     * @throws Exception if an error occurs during the configuration
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(c -> c.disable())
                .authorizeHttpRequests(req -> {
//                            req.anyRequest().permitAll();
//                        })
//                        .build();
//    }
                    req.requestMatchers("/api/users/**").permitAll();
                    req.requestMatchers("/api/products/**").permitAll();
                    req.requestMatchers("/api/auth/**").permitAll();
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }
    /**
     * Defines an authentication provider using DaoAuthenticationProvider with a custom user details service
     * and password encoder for authentication.
     *
     * @return An AuthenticationProvider bean that uses BCryptPasswordEncoder for password hashing
     */
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

    /**
     * Provides the password encoder used to hash and verify user passwords.
     *
     * @return A PasswordEncoder bean that uses BCrypt with a strength of 12 for hashing passwords
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /**
     * Configures the AuthenticationManager bean for managing user authentication.
     *
     * @param configuration The AuthenticationConfiguration object used to obtain the AuthenticationManager
     * @return The AuthenticationManager bean used for handling authentication requests
     * @throws Exception if an error occurs during the creation of the AuthenticationManager
     */
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
