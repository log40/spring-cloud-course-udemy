package com.lblandi.itemms.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<Map<String, String>> handleException(WebClientResponseException e) {
        return ResponseEntity.status(e.getStatusCode()).body(
                Collections.singletonMap("message", e.getMessage())
        );
    }
}


