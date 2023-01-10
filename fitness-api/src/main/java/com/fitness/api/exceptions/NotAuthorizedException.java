package com.fitness.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException() {
        super("User is UNAUTHORIZED");
    }
}
