package dev.kaykyfreitas.springboottemplate.exception;

public class ApiValidationException extends RuntimeException {

    public ApiValidationException(String message) {
        super(message);
    }

}
