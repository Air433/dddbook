package com.example.bank.domain.service.impl;

import com.example.bank.domain.entity.Account;
import com.example.bank.domain.service.AccountTransferService;
import com.example.bank.exception.DailyLimitExceededException;
import com.example.bank.exception.InsufficientFundsException;
import com.example.bank.exception.InvalidCurrencyException;
import com.example.bank.types.ExchangeRate;
import com.example.bank.types.Money;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {
    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney =  exchangeRate.exchageTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
