package com.bank.cli;

import java.util.Scanner;

import com.bank.models.AccountType;
import com.bank.services.impl.AccountCreationServiceImpl;

public class CreateAccountOperationCLI {
    private AccountCreationServiceImpl accountCreationService;

    public CreateAccountOperationCLI(AccountCreationServiceImpl accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter client ID: ");
        String clientId = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter account type (SAVINGS, CHECKING, FIXED): ");
        String accountTypeStr = scanner.nextLine();
        AccountType accountType = AccountType.valueOf(accountTypeStr.toUpperCase());
        accountCreationService.createAccount(accountType, clientId, accountNumber, initialBalance);
    }
}    