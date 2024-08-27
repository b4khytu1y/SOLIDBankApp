package com.bank.cli;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.bank.services.AccountService;

@Component
public class MyCLI {
    private final AccountService accountService;
    private final Scanner scanner;

    public MyCLI(AccountService accountService) {
        this.accountService = accountService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Enter operation number:");
            System.out.println("1 - show accounts");
            System.out.println("2 - create account");
            System.out.println("3 - deposit");
            System.out.println("4 - withdraw");
            System.out.println("5 - transfer");
            System.out.println("6 - this message");
            System.out.println("7 - exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> accountService.showAccounts();
                case 2 -> createAccount();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> transfer();
                case 6 -> printMenu();
                case 7 -> {
                    System.out.println("Application Closed");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.println("Choose account type [1: CHECKING, 2: SAVING, 3: FIXED]:");
        int typeChoice = scanner.nextInt();
        String accountType = null;

        switch (typeChoice) {
            case 1 -> accountType = "CHECKING";
            case 2 -> accountType = "SAVING";
            case 3 -> accountType = "FIXED";
            default -> {
                System.out.println("Invalid account type. Please try again.");
                return;
            }
        }

        boolean result = accountService.createAccount(accountType);
        System.out.println(result ? "Bank account created" : "Failed to create account");
    }

    private void deposit() {
        System.out.println("Enter account ID:");
        String accountId = scanner.next();
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        boolean result = accountService.deposit(accountId, amount);
        System.out.println(result ? "Deposit successful" : "Failed to deposit");
    }

    private void withdraw() {
        System.out.println("Enter account ID:");
        String accountId = scanner.next();
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        boolean result = accountService.withdraw(accountId, amount);
        System.out.println(result ? "Withdrawal successful" : "Failed to withdraw");
    }

    private void transfer() {
        System.out.println("Enter source account ID:");
        String sourceAccountId = scanner.next();
        System.out.println("Enter destination account ID:");
        String destinationAccountId = scanner.next();
        System.out.println("Enter amount to transfer:");
        double amount = scanner.nextDouble();
        boolean result = accountService.transfer(sourceAccountId, destinationAccountId, amount);
        System.out.println(result ? "Transfer successful" : "Failed to transfer");
    }

    public void printMenu() {
        System.out.println("Enter operation number:");
        System.out.println("1 - show accounts");
        System.out.println("2 - create account");
        System.out.println("3 - deposit");
        System.out.println("4 - withdraw");
        System.out.println("5 - transfer");
        System.out.println("6 - this message");
        System.out.println("7 - exit");
    }
}
