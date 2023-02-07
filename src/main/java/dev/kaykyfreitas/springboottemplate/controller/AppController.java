package dev.kaykyfreitas.springboottemplate.controller;

import dev.kaykyfreitas.springboottemplate.dto.ResponseDto;
import dev.kaykyfreitas.springboottemplate.utils.response.ResponseUtils;
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
public class AppController implements ResponseUtils {

    private final KafkaTemplate<String, String> kafka;

    @GetMapping("hello")
    public ResponseEntity<ResponseDto<Object>> hello(Principal principal) {
        return success("Hello, " + principal.getName() + "!");
    }

    @GetMapping("producer/{message}")
    public void producer(@PathVariable String message) {
        this.kafka.send("spring", message);
    }

}
