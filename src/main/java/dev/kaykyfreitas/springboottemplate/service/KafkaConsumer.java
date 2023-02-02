package dev.kaykyfreitas.springboottemplate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private KafkaTemplate<String, String> kafka;

    @KafkaListener(topics = "spring", groupId = "spring-group-id")
    public void consumer(String message) {
        System.out.println(message);
    }

}
