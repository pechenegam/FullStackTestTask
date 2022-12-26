package com.pet.demo.exception;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException() {
        super(String.format("Currency not found"));
    }
}
