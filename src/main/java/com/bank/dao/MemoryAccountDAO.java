package com.bank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.models.Account;
@Repository

public class MemoryAccountDAO implements AccountDAO {
    private Map<String, Account> accountMap = new HashMap<>();

    @Override
    public Account getAccount(String accountId) {
        return accountMap.get(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountMap.put(account.getAccountId(), account);
    }

    @Override
    public void deleteAccount(String accountId) {
        accountMap.remove(accountId);
    }
    @Override
    public void addAccount(Account account) {
        accountMap.put(account.getAccountId(), account);
    }
    @Override
    public List<Account> getAllAccount() {
        return new ArrayList<>();
    }
}
