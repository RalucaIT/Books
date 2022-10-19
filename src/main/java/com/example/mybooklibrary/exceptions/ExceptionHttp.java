package com.example.mybooklibrary.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ExceptionHttp {

    @ExceptionHandler(Throwable.class)
        public ResponseEntity<String> handleAllExceptions (Throwable exception) {
            return new ResponseEntity<>("An error has occured: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<String> handleNotFoundException(ResourceNotFoundException exception) {
            return new ResponseEntity<>("Resource not found: " + exception.getMessage(), HttpStatus.NOT_FOUND);
            }

    @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
            return new ResponseEntity<>("Bad request: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

//        @ExceptionHandler(ConstraintViolationException.class)
//        public
}
