package com.auth.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	private final SecretKey secretKey;
	
	
	public JwtService(@Value("${jwt.secret}") String secret) {
		
		byte[] keyBytes=Base64.getDecoder().decode(secret);
		this.secretKey=Keys.hmacShaKeyFor(keyBytes);
		
		
		
	}
	
	
	public String generateToken(String username, String  role) {
		
		Instant now = Instant.now();
		
		
	      return Jwts.builder()
	                .subject(username)
	                .claim("role", role)
	                .issuedAt(Date.from(now))
	                .expiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
	                .signWith(secretKey)
	                .compact();
	}
	

}
