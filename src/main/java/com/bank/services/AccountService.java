package com.bank.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.models.Account;
import com.bank.models.AccountType;
import com.bank.operations.CheckingAccount;
import com.bank.operations.FixedAccount;
import com.bank.operations.SavingAccount;

@Service
public class AccountService {
    private final AccountDAO accountDAO;
    private int accountIdCounter = 1;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public boolean createAccount(String accountType) {
        try {
            AccountType type = AccountType.valueOf(accountType);
            String accountId = String.format("%03d%06d", 1, accountIdCounter++);
            Account account = switch (type) {
                case CHECKING -> new CheckingAccount(accountId, "1", accountIdCounter);
                case SAVING -> new SavingAccount(accountId, "1", accountIdCounter);
                case FIXED -> new FixedAccount(accountId, "1", accountIdCounter);
            };
            accountDAO.addAccount(account);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void showAccount() {
        accountDAO.getAllAccount().forEach(System.out::println);
    }
    public List<Account> getAllAccount() {
        return accountDAO.getAllAccount();
    }
    public boolean deposit(String accountId, double amount) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountId, double amount) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean transfer(String sourceAccountId, String destinationAccountId, double amount) {
        Account sourceAccount = accountDAO.getAccount(sourceAccountId);
        Account destinationAccount = accountDAO.getAccount(destinationAccountId);
        if (sourceAccount != null && destinationAccount != null && amount > 0 && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}