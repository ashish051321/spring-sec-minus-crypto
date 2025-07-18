package com.example.config;

import com.example.security.PasswordEncoder;

/**
 * A simple no-operation password encoder that doesn't use any crypto.
 * This satisfies Spring Security's dependency requirements without crypto.
 */
public class NoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
} 