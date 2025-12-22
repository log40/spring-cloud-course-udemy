package com.lblandi.productms.handler;

import com.lblandi.productms.features.product.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(ProductNotFoundException e) {
        return ResponseEntity.status(404).body(
                Collections.singletonMap("message", e.getMessage())
        );
    }
}
