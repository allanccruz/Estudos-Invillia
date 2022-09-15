package com.github.allanccruz.api.exceptions;

 import org.springframework.dao.EmptyResultDataAccessException;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExeptionConfig {

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity errorNotFound(Exception ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity errorBadRequest(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}


