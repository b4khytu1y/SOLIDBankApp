package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.models.Account;

@Service

public class AccountBindingService {
    private AccountDAO accountDAO;

    public AccountBindingService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account bindAccountToClient(String accountId, String clientId) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null) {
            account.setClientId(clientId);
            accountDAO.saveAccount(account);
            return account;
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}
