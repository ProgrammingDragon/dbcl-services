package com.dbcl.services.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
	@Value("${app.jwt.secret}")
	private String secret;

	@Value("${app.jwt.issuer}")
	private String issuer;

	@Value("${app.jwt.timeout}")
	private Integer timeout;

	public String getGenerateToken(String subject) {
		return Jwts.builder().setSubject(subject).setIssuer(issuer).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(timeout)))
				.signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();
	}

	public boolean isValid(String token, String username) {
		return (username.equalsIgnoreCase(getUsername(token)) && !isExpired(token));
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	public Date getExpire(String token) {
		return getClaims(token).getExpiration();
	}

	public boolean isExpired(String token) {
		return new Date().after(getExpire(token));
	}
}
