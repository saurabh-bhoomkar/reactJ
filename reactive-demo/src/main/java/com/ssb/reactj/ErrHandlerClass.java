package com.ssb.reactj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrHandlerClass {
    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseEntity eatSomeErrorsInHere(ResponseStatusException t) {
        return ResponseEntity.status(t.getRawStatusCode()).body(t.getMessage());
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity eatAllErrorsInHere(Throwable t) {
        return ResponseEntity.status(500).body(t.getMessage());
    }
}