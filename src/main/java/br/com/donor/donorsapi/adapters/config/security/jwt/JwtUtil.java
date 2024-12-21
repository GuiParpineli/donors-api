package br.com.donor.donorsapi.adapters.config.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtUtil {
    String extractUserName(String token);

    Date extractExpiration(String token);

    Date extractClaimDate(String token);

    String extractClaimUserName(String token);

    String generateToken(UserDetails userDetails);
    Boolean validateToken(String token, UserDetails userDetails);
}
