package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.service.AccountService;

@Component
public class AccountBasicCLI {

    @Autowired
    private AccountService accountService;

    public void getAccounts(String clientID) {
        accountService.getAllAccounts(clientID).forEach(System.out::println);
    }

    public void createAccountRequest(String clientID) {
        accountService.createAccount(clientID);
    }
}
