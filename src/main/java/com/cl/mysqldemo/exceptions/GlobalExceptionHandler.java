package com.cl.mysqldemo.exceptions;


import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public Map<String, String>handelValidationException(Exception ex){
        Map<String,String> errors= new HashMap<>();
        errors.put(ex.getMessage(), ex.getLocalizedMessage());
        return errors;
    }

}
