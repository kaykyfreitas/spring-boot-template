package dev.kaykyfreitas.springboottemplate.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@RequiredArgsConstructor
public class ExceptionDto {

    private final ZonedDateTime timestamp;
    private final Integer status;
    private final HttpStatus error;
    private final String message;

}
