package com.bank.operations;

import com.bank.models.Account;
import com.bank.models.AccountType;

public class FixedAccount extends Account {
    public FixedAccount(String clientId, String accountNumber, double balance) {
        super(AccountType.FIXED, clientId, accountNumber, balance, false);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawals are not allowed on a FixedAccount.");
    }
}