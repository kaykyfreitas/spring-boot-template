package dev.kaykyfreitas.springboottemplate;

import dev.kaykyfreitas.springboottemplate.config.ApiConstants;
import dev.kaykyfreitas.springboottemplate.config.security.RSAKeyProperties;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.LocalDateTime;
import java.util.TimeZone;

@Slf4j
@EnableKafka
@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties(RSAKeyProperties.class)
public class SpringBootTemplateApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(ApiConstants.DEFAULT_TIMEZONE));
		log.info("Actual hour :: {}", LocalDateTime.now());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateApplication.class, args);
	}

}
