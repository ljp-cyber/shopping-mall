package com.ljp.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String SUBJECT = "shopping mall";

	public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;

	public static final String APPSECRET_KEY = "I will be a good programer";

	private static final String NAME_CLAIMS = "name";
	private static final String PW_CLAIMS = "pw";
	private static final String ROLE_CLAIMS = "role";

	public static String generateJsonWebToken(UserDetails user) {

		if (user.getUsername() == null /*|| user.getPassword() == null*/ || user.getAuthorities() == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<>();

		String token = 
				Jwts.builder()
				.setSubject(SUBJECT)
				.setClaims(map)
				.claim(NAME_CLAIMS, user.getUsername())
				.claim(PW_CLAIMS, user.getPassword())
				.claim(ROLE_CLAIMS, user.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
				.signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
		return token;
	}

	public static Claims checkJWT(String token) {
		try {
			final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
			return claims;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getUserName(Claims claims) {
		return claims.get(NAME_CLAIMS).toString();
	}

	public static String getUserPassword(Claims claims) {
		return claims.get(PW_CLAIMS).toString();
	}

	public static String getUserRole(Claims claims) {
		return claims.get(ROLE_CLAIMS).toString();
	}

	public static boolean isExpiration(Claims claims) {
		return claims.getExpiration().before(new Date());
	}

	public static void main(String[] args) {
		UserBuilder builder = User.builder();
		builder.username("ljp");
		builder.password("good");
		builder.roles("admin");
		builder.passwordEncoder(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t;
			}
		});
		UserDetails user = builder.build();
		String token = generateJsonWebToken(user);

		System.out.println(token);

		Claims claims = checkJWT(token);
		if (claims != null) {
			System.out.println("name:" + getUserName(claims));
			System.out.println("passwork:" + getUserPassword(claims));
			System.out.println("role:" + getUserRole(claims));

		}

	}

}
