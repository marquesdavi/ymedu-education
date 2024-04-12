package com.api.ymedu.util.handler;

import com.api.ymedu.util.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GenericExceptionHandler {
    public ResponseEntity<String> handleGenericException(GenericException exception){

        return ResponseEntity.status(HttpStatus.resolve(exception.getStatusCode())).body(exception.getMessage());
    }
}
