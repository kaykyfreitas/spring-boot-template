package dev.kaykyfreitas.springboottemplate.utils.response;

import dev.kaykyfreitas.springboottemplate.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseUtils {

    default <T> ResponseEntity<ResponseDto<T>> success(T content) {
        return response(HttpStatus.OK, content);
    }

    default <T> ResponseEntity<ResponseDto<T>> created(T content) {
        return response(HttpStatus.CREATED, content);
    }

    default <T> ResponseEntity<ResponseDto<T>> notFound(T content) {
        return response(HttpStatus.NOT_FOUND, content);
    }

    default <T> ResponseEntity<ResponseDto<T>> badRequest(T content) {
        return response(HttpStatus.BAD_REQUEST, content);
    }

    private <T> ResponseEntity<ResponseDto<T>> response(HttpStatus httpStatus, T content) {
        return ResponseEntity.status(httpStatus.value()).body(new ResponseDto<>(httpStatus, content));
    }

}
