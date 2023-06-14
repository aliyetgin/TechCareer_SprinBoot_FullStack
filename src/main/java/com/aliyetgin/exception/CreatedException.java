package com.aliyetgin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 201: created
@ResponseStatus(value = HttpStatus.CREATED)
public class CreatedException extends RuntimeException {

    public CreatedException(String message) {
        super(message);
    }
}
