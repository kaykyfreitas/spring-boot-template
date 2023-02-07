package dev.kaykyfreitas.springboottemplate.controller;

import dev.kaykyfreitas.springboottemplate.dto.AuthDto;
import dev.kaykyfreitas.springboottemplate.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @GetMapping("/auth")
    ResponseEntity<AuthDto> token(Authentication authentication) {
        return ResponseEntity.ok(tokenService.generateToken(authentication));
    }

}
