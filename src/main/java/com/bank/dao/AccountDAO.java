package com.bank.dao;

import java.util.List;

import com.bank.models.Account;

public interface AccountDAO {
    Account getAccount(String accounId);
    void saveAccount(Account account);
    void deleteAccount(String accounId);
    void addAccount(Account account);
    List<Account> getAllAccount();
}


