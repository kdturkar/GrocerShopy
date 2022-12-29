package com.app.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // 5 hours

	@Value("${jwt.secret}") // SpEL - jwt.secret in application.properties
	private String secret;

//retrieve username from jwt token
	public Integer extractIdFromToken(String token) {
		return Integer.parseInt(getClaimFromToken(token, Claims::getSubject));
	}

//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieving any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);

		// Extract expiration date if it is created before new Date()
		// if it is created before 5 hour it will return true
		return expiration.before(new Date());
	}

	// First time User will send user name & password as part of request header
	// Based on id we are generating token
//generate token for user
	public String generateToken(Integer id) {
		// claims is an empty map
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, id.toString());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the SHA256 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		// date --> token issued date
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		// Extracting id from encrypted token string
		final Integer id = extractIdFromToken(token);
		return (id.toString().equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
