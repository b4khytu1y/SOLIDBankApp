package com.bank.dao;

import com.bank.models.Account; 
import java.util.ArrayList;
import java.util.List;

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
}