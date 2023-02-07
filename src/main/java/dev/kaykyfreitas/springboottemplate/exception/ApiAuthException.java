package dev.kaykyfreitas.springboottemplate.exception;

public class ApiAuthException extends RuntimeException{

    public ApiAuthException(String message) {
        super(message);
    }

}
