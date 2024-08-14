package com.bank.cli;

import java.util.Scanner;

import com.bank.services.TransactionDepositService;

public class TransactionDepositCLI {
    private TransactionDepositService transactionDepositService;

    public TransactionDepositCLI(TransactionDepositService transactionDepositService) {
        this.transactionDepositService = transactionDepositService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        transactionDepositService.deposit(accountNumber, amount);
    }
}