package com.example.bank.types;

import java.math.BigDecimal;

public class ExchangeRate {

    private BigDecimal rage;
    private Currency source;
    private Currency target;

    public ExchangeRate(BigDecimal rage, Currency source, Currency target) {
        this.rage = rage;
        this.source = source;
        this.target = target;
    }

    public Money exchageTo(Money targetMoney)  {
        BigDecimal targetMount = targetMoney.getAmout().multiply(rage);
        return new Money(targetMount, target);
    }
}
