package dev.kaykyfreitas.springboottemplate.dto;

import dev.kaykyfreitas.springboottemplate.config.ApiConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public final class ResponseDto<T> extends ApiDto {

    private final LocalDateTime timestamp;

    private final Integer statusCode;

    private transient T data;

    private final String applicationName;

    public ResponseDto(HttpStatus status, T data) {
        this.timestamp = LocalDateTime.now();
        this.statusCode = status.value();
        this.data = data;
        this.applicationName = ApiConstants.APPLICATION_NAME;
    }

}
