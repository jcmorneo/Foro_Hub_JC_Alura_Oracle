package com.forohub.jc.service;

import com.forohub.jc.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private final JwtUtil jwtUtil;

    public TokenService(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
    }

    // Método para generar un token JWT
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return jwtUtil.generateToken(claims, userDetails.getUsername());
    }

    // Método para validar un token JWT
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = jwtUtil.extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !jwtUtil.isTokenExpired(token));
    }
}
