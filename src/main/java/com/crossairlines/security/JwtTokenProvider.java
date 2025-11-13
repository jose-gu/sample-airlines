package com.crossairlines.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.crossairlines.model.User;

@Component
public class JwtTokenProvider {

    private String jwtSecret = "crossAirlinesSecretKey";
    private int jwtExpirationInMs = 86400000; // 24 hours

    public boolean validateToken(String token) {
        try {
            // Simple validation - in real implementation use JWT library
            return token != null && !token.trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public User extractUserFromToken(String token) {
        try {
            // Simple extraction - in real implementation parse JWT
            // For now, return null as this is a placeholder
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isTokenValid(String token) {
        try {
            if (token == null || token.trim().isEmpty()) {
                return false;
            }
            
            // Simple validation - check if it's a JWT-like format
            if (token.split("\\.").length == 3) {
                return validateToken(token);
            }
            
            // If not JWT format, treat as legacy user ID
            try {
                Integer.parseInt(token);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
        // Simple token generation - in real implementation use JWT library
        return "jwt." + user.getUserId() + "." + expiryDate.getTime();
    }
}