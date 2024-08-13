package com.bank.dao;

import com.bank.models.Account; 

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account);
    List<Account> getAllAccounts();
}