package com.example.bank.exception;

public class MoneyAmoutNotNullException extends IllegalArgumentException{

    public MoneyAmoutNotNullException(String message) {
        super(message);
    }
}
