package dev.kaykyfreitas.springboottemplate.service;

import dev.kaykyfreitas.springboottemplate.dto.AuthDto;
import dev.kaykyfreitas.springboottemplate.exception.ApiAuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtEncoder jwtEncoder;

    public AuthDto generateToken(Authentication authentication) {

        try {

            Instant now = Instant.now();

            String scope = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));

            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plus(1, ChronoUnit.HOURS))
                    .subject(authentication.getName())
                    .claim("scope", scope)
                    .build();

            var token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

            var username = authentication.getName();
            var roles = authentication.getAuthorities().stream().map(Object::toString).toList();

            log.info("Token requested for user: '{}'", username);
            log.info("User roles: {}", roles);
            log.info("Token granted {}", token);

            return new AuthDto(username, token, roles);

        } catch (Exception e) {

            throw new ApiAuthException("Error on token generation");

        }

    }

}
