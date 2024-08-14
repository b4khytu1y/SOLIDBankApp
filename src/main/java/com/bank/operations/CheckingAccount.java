package com.bank.operations;

import com.bank.models.Account;
import com.bank.models.AccountType;

public class CheckingAccount extends Account {
    public CheckingAccount(String clientId, String accountNumber, double balance) {
        super(AccountType.CHECKING, clientId, accountNumber, balance, true);
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