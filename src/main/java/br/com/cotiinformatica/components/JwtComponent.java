package br.com.cotiinformatica.components;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtComponent {
	
	@Value("${jwt.secretkey}")
	private String jwtSecretkey;

	public UUID getUser(HttpServletRequest request) {
		try {

			String authorization = request.getHeader("Authorization");
			if (authorization == null || !authorization.startsWith("Bearer ")) {
				return null;
			}

			String token = authorization.substring(7);

			Claims claims = Jwts.parser()
					.setSigningKey(jwtSecretkey.getBytes(StandardCharsets.UTF_8))
					.parseClaimsJws(token).getBody();

			var user = claims.getSubject();
			
			return UUID.fromString(user);
		} catch (Exception e) {
			return null;
		}
	}
}