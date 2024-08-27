package com.bank.models;

public class CheckingAccount extends Account {
    public CheckingAccount(String accountId, String clientId) {
        super(AccountType.CHECKING, accountId, clientId);
    }
}