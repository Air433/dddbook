package com.example.bank.types;

public class Currency {

    private String value;

    public Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value='" + value + '\'' +
                '}';
    }
}
