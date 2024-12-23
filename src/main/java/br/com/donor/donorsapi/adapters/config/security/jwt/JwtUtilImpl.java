package br.com.donor.donorsapi.adapters.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtilImpl implements JwtUtil {
    @Getter
    public static final int EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    private final SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("m4Kx7/NyL3aF9qzBX5R8vPtGQkl1MZcWiUBM2v4qGzE="));

    @Override
    public String extractUserName(String token) {
        return extractClaimUserName(token);
    }

    @Override
    public Date extractExpiration(String token) {
        return extractClaimDate(token);
    }

    @Override
    public Date extractClaimDate(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public String extractClaimUserName(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        String claims = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return createToken(claims, userDetails.getUsername());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String createToken(String claims, String subject) {
        return Jwts.builder()
                .claim("role", claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
