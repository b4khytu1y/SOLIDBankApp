package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.service.TransactionService;

@Component
public class TransactionDepositCLI {

    @Autowired
    private TransactionService transactionService;

    public void depositMoney(String clientID) {
        transactionService.deposit(clientID);
    }
}
