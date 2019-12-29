package com.example.bank.application.impl;

import com.example.bank.application.TransferService;
import com.example.bank.common.Result;
import com.example.bank.domain.entity.Account;
import com.example.bank.domain.service.AccountTransferService;
import com.example.bank.domain.types.AuditMessage;
import com.example.bank.exception.DailyLimitExceededException;
import com.example.bank.exception.InsufficientFundsException;
import com.example.bank.exception.InvalidCurrencyException;
import com.example.bank.external.ExchangeRateService;
import com.example.bank.messaging.AuditMessageProducer;
import com.example.bank.repository.AccountRepository;
import com.example.bank.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountRepository accountRepository;

    private AuditMessageProducer auditMessageProducer;
    private ExchangeRateService exchangeRateService;
    private AccountTransferService accountTransferService;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException {
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));

        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));

        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        accountRepository.save(sourceAccount);

        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return Result.success(true);
    }
}
