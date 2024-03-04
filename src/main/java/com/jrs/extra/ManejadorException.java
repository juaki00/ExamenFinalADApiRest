package com.jrs.extra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(AutenticacionException.class)
    public ResponseEntity<String> handleAuthenticationException( AutenticacionException ex) {
        return new ResponseEntity<>( ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}