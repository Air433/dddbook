package com.example.bank.persistence;

import java.math.BigDecimal;

public class AccountDO {

    private Long id;

    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmout;
    private BigDecimal dailyLimitAmout;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAvailableAmout() {
        return availableAmout;
    }

    public void setAvailableAmout(BigDecimal availableAmout) {
        this.availableAmout = availableAmout;
    }

    public BigDecimal getDailyLimitAmout() {
        return dailyLimitAmout;
    }

    public void setDailyLimitAmout(BigDecimal dailyLimitAmout) {
        this.dailyLimitAmout = dailyLimitAmout;
    }

    @Override
    public String toString() {
        return "AccountDO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", userId=" + userId +
                ", availableAmout=" + availableAmout +
                ", dailyLimitAmout=" + dailyLimitAmout +
                ", currency='" + currency + '\'' +
                '}';
    }
}
