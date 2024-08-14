package com.bank.operations;

import com.bank.models.Account;
import com.bank.models.AccountType;

public class AccountDeposit extends Account {
    public AccountDeposit(String clientId, String accountNumber, double balance) {
        super(AccountType.SAVING, clientId, accountNumber, balance, true);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawals are not supported for AccountDeposit.");
    }
}