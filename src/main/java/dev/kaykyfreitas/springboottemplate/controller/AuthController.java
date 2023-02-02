package dev.kaykyfreitas.springboottemplate.controller;

import dev.kaykyfreitas.springboottemplate.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;


    @PostMapping("/token")
    public String token(Authentication authentication) {
        log.info("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.info("Token granted {}", token);
        return token;
    }

}
