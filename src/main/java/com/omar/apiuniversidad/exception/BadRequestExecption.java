package com.omar.apiuniversidad.exception;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BadRequestExecption extends RuntimeException{
    public BadRequestExecption(String message){
        super(message);
    }

}
