package com.example.bank.persistence.impl;

import com.example.bank.persistence.AccountDO;
import com.example.bank.persistence.AccountMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountMapperImpl implements AccountMapper {
    @Override
    public int insert(AccountDO accountDO) {
        System.err.println("------------------插入:"+ accountDO);
        return 0;
    }

    @Override
    public int update(AccountDO accountDO) {
        System.err.println("------------------更新:"+ accountDO);
        return 0;
    }

    @Override
    public AccountDO selectByUserId(Long id) {
        return null;
    }

    @Override
    public AccountDO selectByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public AccountDO selectById(Long id) {
        return null;
    }
}
