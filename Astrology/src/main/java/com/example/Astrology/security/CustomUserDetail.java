package com.example.Astrology.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * CustomUserDetail implements UserDetails and provides a custom user representation
 * for use with Spring Security authentication. This class holds the necessary user data (username and password)
 * required for authentication and authorization purposes in the application.
 */
public class CustomUserDetail implements UserDetails {

    private String username;
    private String password;

    /**
     * Constructs a new CustomUserDetail with the specified username and password.
     *
     * @param username The username of the user
     * @param password The password of the user
     */
    public CustomUserDetail(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the authorities granted to the user.
     * This implementation does not assign any authorities, returning null
     *
     * @return A collection of granted authorities (empty in this case)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the password used for authentication.
     *
     * @return The password of the user
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the username used for authentication.
     *
     * @return The username of the user
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Indicates whether the user's account has expired.
     * In this implementation, the account is always considered non-expired.
     *
     * @return true if the account is non-expired, otherwise false
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's account is locked.
     * In this implementation, the account is always considered non-locked.
     *
     * @return true if the account is non-locked, otherwise false
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) have expired.
     * In this implementation, the credentials are always considered non-expired.
     *
     * @return true if the credentials are non-expired, otherwise false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled.
     * In this implementation, the user is always considered enabled.
     *
     * @return true if the user is enabled, otherwise false
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
