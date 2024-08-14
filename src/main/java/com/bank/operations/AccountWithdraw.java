package com.bank.operations;

import com.bank.models.Account;
import com.bank.models.AccountType;

public class AccountWithdraw extends Account {
    public AccountWithdraw(String clientId, String accountNumber, double balance) {
        super(AccountType.CHECKING, clientId, accountNumber, balance, true);
    }

    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Deposits are not supported for AccountWithdraw.");
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