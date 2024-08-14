package com.bank.operations;

import com.bank.models.Account;
import com.bank.models.AccountType;

public class SavingAccount extends Account {
    public SavingAccount(String clientId, String accountNumber, double balance) {
        super(AccountType.SAVING, clientId, accountNumber, balance, true);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawAllowed && balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Withdrawal not allowed or insufficient balance.");
        }
    }
}