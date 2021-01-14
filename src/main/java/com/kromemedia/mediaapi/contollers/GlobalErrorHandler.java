package com.kromemedia.mediaapi.contollers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SimpleMessage> globalExceptionHandler(Exception e) {

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(new SimpleMessage("global", e.getMessage()), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
