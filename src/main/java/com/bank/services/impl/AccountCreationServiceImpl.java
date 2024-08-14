package com.bank.services.impl;

import com.bank.dao.AccountDAO;
import com.bank.models.Account;
import com.bank.models.AccountType;
import com.bank.operations.CheckingAccount;
import com.bank.operations.FixedAccount;
import com.bank.operations.SavingAccount;

public class AccountCreationServiceImpl {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void createAccount(AccountType accountType, String clientId, String accountNumber, double initialBalance) {
        Account account;
        switch (accountType) {
            case SAVING:
                account = new SavingAccount(clientId, accountNumber, initialBalance);
                break;
            case CHECKING:
                account = new CheckingAccount(clientId, accountNumber, initialBalance);
                break;
            case FIXED:
                account = new FixedAccount(clientId, accountNumber, initialBalance);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
        accountDAO.saveAccount(account);
    }
}