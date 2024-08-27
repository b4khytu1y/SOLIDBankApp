package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.service.TransactionService;

@Component
public class TransactionWithdrawCLI {

    @Autowired
    private TransactionService transactionService;

    public void withdrawMoney(String clientID) {
        transactionService.withdraw(clientID);
    }
}
