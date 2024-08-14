package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.models.Account;
@Service

public class AccountHandleTransferService {
    private AccountDAO accountDAO;

    public AccountHandleTransferService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accountDAO.getAccount(fromAccountNumber);
        Account toAccount = accountDAO.getAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        accountDAO.saveAccount(fromAccount);
        accountDAO.saveAccount(toAccount);
    }
}