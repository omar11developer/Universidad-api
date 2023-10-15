package com.omar.apiuniversidad.exception;

public class BadRequestExecption extends RuntimeException{
    public BadRequestExecption(String message){
        super(message);
    }
}
