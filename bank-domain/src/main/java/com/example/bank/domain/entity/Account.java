package com.example.bank.domain.entity;

import com.example.bank.exception.DailyLimitExceededException;
import com.example.bank.exception.InsufficientFundsException;
import com.example.bank.exception.InvalidCurrencyException;
import com.example.bank.exception.MoneyAmoutNotNullException;
import com.example.bank.types.*;

public class Account {

    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    private Currency currency;

    public AccountId getId() {
        return id;
    }

    public void setId(AccountId id) {
        this.id = id;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Money getAvailable() {
        return available;
    }

    public void setAvailable(Money available) {
        this.available = available;
    }

    public Money getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(Money dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    // 转出
    public void withdraw(Money money) throws Exception, DailyLimitExceededException {
        if (this.available.compareTo(money) < 0){
            throw new InsufficientFundsException();
        }

        if (this.dailyLimit.compareTo(money) < 0){
            throw new DailyLimitExceededException();
        }

        this.available = this.available.subtract(money);
    }

    // 转入
    public void deposit(Money money) throws InvalidCurrencyException, MoneyAmoutNotNullException {
       if (!this.getCurrency().equals(money.getCurrency())){
           throw new InvalidCurrencyException();
       }

       this.available = this.available.add(money);

    }
}
