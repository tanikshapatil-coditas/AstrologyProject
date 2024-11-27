package com.example.Astrology.security;

import com.example.Astrology.entity.Astrologer;
import com.example.Astrology.exception.InvalidUserIdException;
import com.example.Astrology.repository.AstrologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailService is a service that implements the UserDetailsService interface,
 * responsible for loading user-specific data used by Spring Security for authentication and authorization.
 * This service retrieves user information from the repository by username and provides it as a custom UserDetails object.
 */
@AllArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AstrologyRepository astrologyRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Astrologer astrologer = astrologyRepository.findByUsername(username)
                .orElseThrow(
                        InvalidUserIdException::new
                );
        return new CustomUserDetail(astrologer.getUsername(), astrologer.getPassword());


    }
}
