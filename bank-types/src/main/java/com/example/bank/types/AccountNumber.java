package com.example.bank.types;

import com.example.bank.exception.BusinessException;

public class AccountNumber {

    private String value;

    public AccountNumber(String value) throws BusinessException {
        if (value == null || "".equals(value)){
            throw new BusinessException("账号不能为空");
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
