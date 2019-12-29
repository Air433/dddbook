package com.example.bank.repository;

import com.example.bank.domain.entity.Account;
import com.example.bank.types.AccountId;
import com.example.bank.types.AccountNumber;
import com.example.bank.types.UserId;

public interface AccountRepository {
    Account find(AccountId id) throws Exception;
    Account find(AccountNumber accountNumber) throws Exception;
    Account find(UserId userId) throws Exception;
    Account save(Account account) throws Exception;
}
