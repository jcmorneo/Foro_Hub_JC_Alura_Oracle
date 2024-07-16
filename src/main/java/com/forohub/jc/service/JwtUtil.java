package com.forohub.jc.service;

import java.util.Map;

public class JwtUtil {
    public String generateToken(Map<String, Object> claims, String username) {
        return username;
    }

    public String extractUsername(String token) {
        return token;
    }

    public boolean isTokenExpired(String token) {
        return false;
    }
}
