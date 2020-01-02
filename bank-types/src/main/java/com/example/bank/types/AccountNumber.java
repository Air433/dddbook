package com.example.bank.types;


public class AccountNumber {

    private String value;

    public AccountNumber(String value) {
        if (value == null || "".equals(value)){
            throw new IllegalArgumentException("账号不能为空");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
