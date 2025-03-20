package com.example.dtsplatform.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String ex) {
        super(ex);
    }
}