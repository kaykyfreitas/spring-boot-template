package dev.kaykyfreitas.springboottemplate.exception;

public class ApiServiceException extends RuntimeException {

    public ApiServiceException(String message) {
        super(message);
    }

}
