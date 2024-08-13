package com.bank.cli;

import java.util.Scanner;

import com.bank.services.AccountService;

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
            System.out.println("3 - exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> accountService.showAccounts();
                case 2 -> createAccount();
                case 3 -> {
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
    
}
