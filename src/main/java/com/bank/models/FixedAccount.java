package com.bank.models;

public class FixedAccount extends Account {
    public FixedAccount(String accountId, String clientId) {
        super(AccountType.FIXED, accountId, clientId);
    }
}