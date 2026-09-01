package com.shivam.studentmanagenement.service;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private final SecretKey key = Keys.hmacShaKeyFor("shivam-student-management-secret-key-2026".getBytes());
    public String generateToken(String username){
        return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 *60*60))
        .signWith(key)
        .compact();
    }
    public String extractUsername(String token){
        return Jwts.parser()
        .verifyWith(key) 
        .build()  
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    }
    public boolean isTokenValid(String token, String username){
        return extractUsername(token).equals(username);
    }
}
