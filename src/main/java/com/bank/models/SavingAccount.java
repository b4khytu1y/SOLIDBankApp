package com.bank.models;


public class SavingAccount extends Account {
    public SavingAccount(String accountId, String clientId) {
        super(AccountType.SAVING, accountId, clientId);
    }
}