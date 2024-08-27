package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.models.Account;
import com.bank.models.AccountType;
import com.bank.models.CheckingAccount;
import com.bank.models.FixedAccount;
import com.bank.models.SavingAccount;

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
                case CHECKING -> new CheckingAccount(accountId, "1");
                case SAVING -> new SavingAccount(accountId, "1");
                case FIXED -> new FixedAccount(accountId, "1");
            };
            accountDAO.addAccount(account);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void showAccounts() {
        accountDAO.getAllAccounts().forEach(System.out::println);
    }

    public boolean deposit(String accountId, double amount) {
        Account account = accountDAO.getAccountById(accountId);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountId, double amount) {
        Account account = accountDAO.getAccountById(accountId);
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean transfer(String sourceAccountId, String destinationAccountId, double amount) {
        Account sourceAccount = accountDAO.getAccountById(sourceAccountId);
        Account destinationAccount = accountDAO.getAccountById(destinationAccountId);
        if (sourceAccount != null && destinationAccount != null && amount > 0 && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public Account getAccountById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountById'");
    }

    public boolean updateAccount(String id, Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    public void deleteAccount(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }
    
}