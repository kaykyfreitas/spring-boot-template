package dev.kaykyfreitas.springboottemplate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("hello")
    public ResponseEntity<String> hello(Principal principal) {
        var message = "Hello, " + principal.getName() + "!";
        return ResponseEntity.ok(message);
    }

}
