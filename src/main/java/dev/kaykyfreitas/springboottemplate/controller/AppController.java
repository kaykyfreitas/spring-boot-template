package dev.kaykyfreitas.springboottemplate.controller;

import dev.kaykyfreitas.springboottemplate.exception.ApiRequestException;
import dev.kaykyfreitas.springboottemplate.exception.ApiServiceException;
import dev.kaykyfreitas.springboottemplate.exception.ApiValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppController {

    private final KafkaTemplate<String, String> kafka;

    @GetMapping("hello")
    public ResponseEntity<String> hello(Principal principal) {
        var message = "Hello, " + principal.getName() + "!";
        return ResponseEntity.ok(message);
    }

    @GetMapping("producer/{message}")
    public void producer(@PathVariable String message) {
        this.kafka.send("spring", message);
    }

    @GetMapping("fail/1")
    public void test1() {
        throw new RuntimeException("Invalid request");
    }

    @GetMapping("fail/2")
    public void test2() {
        throw new ApiRequestException("Request exception");
    }

    @GetMapping("fail/3")
    public void test3() {
        throw new ApiServiceException("Service exception");
    }

    @GetMapping("fail/4")
    public void test4() {
        throw new ApiValidationException("Validation exception");
    }

}
