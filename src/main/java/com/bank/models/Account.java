package com.bank.models;

public abstract class Account {
    protected AccountType accountType;
    protected String clientId;
    protected String accountId;
    protected double balance;
    protected boolean withdrawAllowed;

    public Account(AccountType accountType, String clientId, String accountId, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.clientId = clientId;
        this.accountId = accountId;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    @Override
    public String toString() {
        return "Account{" +
                "id='" + accountId + '\'' +
                ", clientID='" + clientId + '\'' +
                ", balance=" + balance +
                '}';
    }

    
}
