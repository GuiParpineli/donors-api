package br.com.donor.donorsapi.web.controller.auth;

import br.com.donor.donorsapi.adapters.config.security.jwt.JwtUtil;
import br.com.donor.donorsapi.web.controller.auth.dto.TokenDto;
import br.com.donor.donorsapi.web.controller.auth.dto.UserDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.donor.donorsapi.adapters.config.security.jwt.JwtUtilImpl.EXPIRATION_TIME;


@RestController
@RequestMapping(value = "public/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Auth", description = "Auth operations")
public class AuthController {
    private final UserDetailsService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserDetailsService service, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserDto userApp) {
        UserDetails userDetails = service.loadUserByUsername(userApp.username());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userApp.username(), userApp.password())
        );
        String jwt = jwtUtil.generateToken(userDetails);
        TokenDto tokenDto = new TokenDto(jwt, EXPIRATION_TIME);
        return ResponseEntity.ok(tokenDto);
    }
}
