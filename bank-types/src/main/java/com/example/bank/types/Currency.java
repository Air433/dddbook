package com.example.bank.types;


public class Currency {

    private String value;

    public Currency(String value) {
        if (value == null || "".equals(value)){
            throw new IllegalArgumentException("货币不能为空");
        }
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
