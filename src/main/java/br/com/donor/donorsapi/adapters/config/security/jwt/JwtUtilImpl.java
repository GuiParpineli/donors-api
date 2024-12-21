package br.com.donor.donorsapi.adapters.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtilImpl implements JwtUtil {
    private static final String QUARKBYTE = "quarkbyte";
    @Getter
    public static final int EXPIRATION_TIME = 36000;
    SecretKey key = Jwts.SIG.HS256.key().build();

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
                .verifyWith(key)
                .build()
                .parseEncryptedClaims(token).getPayload();
    }

    private String createToken(String claims, String subject) {
        return Jwts.builder()
                .issuer(QUARKBYTE)
                .claim("role", claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key).compact();
    }


    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
