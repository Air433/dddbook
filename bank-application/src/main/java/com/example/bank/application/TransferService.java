package com.example.bank.application;

import com.example.bank.common.Result;
import com.example.bank.exception.DailyLimitExceededException;
import com.example.bank.exception.InsufficientFundsException;
import com.example.bank.exception.InvalidCurrencyException;

import java.math.BigDecimal;

public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException;

}