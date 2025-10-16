package com.capgemini.training.manjeet.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Author Manjeet Kumar 30-Jul-2025
 */

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	private String secret;

	/**
	 * @param username
	 * @return
	 */
	public String generateToken(String username) {
		return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

	//return null;
	
	public boolean validateToken(String token) {
        try {
           Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	

public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


	}


//isTokenValid
	// public Boolean validateToken(String token, UserDetails userDetails) {}

	// private Boolean isTokenExpired(String token) {}

	// public Date extractExpiration(String token) {}

	// public String generateToken(UserDetails userDetails) {}

	// private String createToken(Map<String, Object> claims, String subject) {}

