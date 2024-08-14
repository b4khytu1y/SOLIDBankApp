package com.bank.cli;

import java.util.Scanner;

import com.bank.services.TransactionWithdrawService;

public class WithdrawOperationCLI {
    private TransactionWithdrawService transactionWithdrawService;

    public WithdrawOperationCLI(TransactionWithdrawService transactionWithdrawService) {
        this.transactionWithdrawService = transactionWithdrawService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        transactionWithdrawService.withdraw(accountNumber, amount);
    }
}