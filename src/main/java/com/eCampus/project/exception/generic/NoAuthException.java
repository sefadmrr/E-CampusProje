package com.eCampus.project.exception.generic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NoAuthException extends RuntimeException{

    public NoAuthException(String message) {
        super(message);
    }
}
