package com.bank.models;

import org.springframework.web.bind.annotation.DeleteMapping;

public class Account {
    private final AccountType accountType;
    private final String accountId;
    private final String clientId;
    private double balance;

    public Account(AccountType accountType, String accountId, String clientId) {
        this.accountType = accountType;
        this.accountId = accountId;
        this.clientId = clientId;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + accountId + '\'' +
                ", clientID='" + clientId + '\'' +
                ", balance=" + balance +
                '}';
    }

    public DeleteMapping getAccountType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountType'");
    }
}
