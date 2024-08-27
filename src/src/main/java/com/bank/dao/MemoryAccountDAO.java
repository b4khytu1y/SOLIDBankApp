package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.models.Account;

@Repository

public class MemoryAccountDAO implements AccountDAO {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Account getAccountById(String accountId) {
        return accounts.stream()
                       .filter(account -> account.getAccountId().equals(accountId))
                       .findFirst()
                       .orElse(null);
    }
}
