package com.example.bank.Exception;

public class CuentaNotFoundException extends RuntimeException {
    public CuentaNotFoundException(String message) {
        super(message);
    }
}