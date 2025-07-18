package com.example.security;

/**
 * Custom PasswordEncoder interface to replace the one from spring-security-crypto.
 * This allows us to exclude the crypto dependency while maintaining compatibility.
 */
public interface PasswordEncoder {
    
    /**
     * Encode the raw password.
     * @param rawPassword the raw password to encode
     * @return the encoded password
     */
    String encode(CharSequence rawPassword);
    
    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not.
     * @param rawPassword the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);
} 