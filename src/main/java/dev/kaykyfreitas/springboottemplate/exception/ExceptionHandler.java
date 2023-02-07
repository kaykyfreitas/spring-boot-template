package dev.kaykyfreitas.springboottemplate.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleRequestException(ApiRequestException e) {
        log.info(e.getMessage());
        var apiException = new ApiException(
                ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))),
                BAD_REQUEST.value(),
                BAD_REQUEST,
                e.getMessage()
        );

        return new ResponseEntity<>(apiException, BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ApiServiceException.class})
    public ResponseEntity<Object> handleServiceException(ApiServiceException e) {
        log.info(e.getMessage());
        var apiException = new ApiException(
                ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR,
                e.getMessage()
        );

        return new ResponseEntity<>(apiException, INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ApiValidationException.class})
    public ResponseEntity<Object> handleValidationException(ApiValidationException e) {
        log.info(e.getMessage());
        var apiException = new ApiException(
                ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))),
                BAD_REQUEST.value(),
                BAD_REQUEST,
                e.getMessage()
        );

        return new ResponseEntity<>(apiException, BAD_REQUEST);
    }

}
