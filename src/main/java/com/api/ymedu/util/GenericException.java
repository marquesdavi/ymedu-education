package com.api.ymedu.util;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{
    private HttpStatus status;
    public GenericException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public int getStatusCode() {
        return this.status.value();
    }
}
