package org.example.simpleuserap.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleException(HttpClientErrorException.NotFound e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DublicateEmailException.class)
    public ResponseEntity<String> duplicateEmailException(DublicateEmailException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);}


    @ExceptionHandler(EmailNotFound.class)
    public ResponseEntity<String> emailNotFound(EmailNotFound e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
