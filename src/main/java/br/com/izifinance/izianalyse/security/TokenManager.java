package br.com.izifinance.izianalyse.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.izifinance.izianalyse.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager {

	@Value("${iziauth.jwt.secret}")
	private String secret;
	@Value("${iziauth.jwt.expiration.time}")
	private Long expirationmillis;
	
	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Date now = new Date();
		Date expiration = new Date(now.getTime()+this.expirationmillis);
		
		return Jwts.builder().setIssuer("IziAnalyse Api")
				.setSubject(user.getId()).setIssuedAt(now)
				.setExpiration(expiration).signWith(SignatureAlgorithm.HS256, this.secret)
				.compact();
	}
	
	public boolean isValid(String jwt) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt);
			return true;
		} catch(JwtException | IllegalArgumentException e) {
			return false;
		}
	}
	
	public String getUserIdFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt).getBody();
		return claims.getSubject();
	}
	
}
