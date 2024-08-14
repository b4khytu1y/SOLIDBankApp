package com.bank.cli;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.bank.services.AccountService;
import com.bank.services.TransactionDepositService;
import com.bank.services.TransactionWithdrawService;

@Component
public class MyCLI {
    private AccountService accountService;
    private TransactionDepositService transactionDepositService;
    private TransactionWithdrawService transactionWithdrawService;
    private Scanner scanner;

    public MyCLI(AccountService accountService, TransactionDepositService transactionDepositService, TransactionWithdrawService transactionWithdrawService) {
        this.accountService = accountService;
        this.transactionDepositService = transactionDepositService;
        this.transactionWithdrawService = transactionWithdrawService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAccount();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    showMenu();
                    break;
                case 7:
                    System.out.println("Application Closed");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nWelcome to CLI bank service");
        System.out.println("Enter operation number:");
        System.out.println("1 - show accounts");
        System.out.println("2 - create account");
        System.out.println("3 - deposit");
        System.out.println("4 - withdraw");
        System.out.println("5 - transfer");
        System.out.println("6 - this message");
        System.out.println("7 - exit");
        System.out.print(">> ");
    }

    private void showAccount() {
        accountService.getAllAccount().forEach(System.out::println);
    }

    private void createAccount() {
        System.out.println("Choose account type [CHECKING, SAVING, FIXED]");
        String accountType = scanner.nextLine().toUpperCase();
    
        boolean accountCreated = accountService.createAccount(accountType);
        if (accountCreated) {
            System.out.println(accountType + " account created");
            accountService.getAllAccount().forEach(System.out::println); // Выводим все аккаунты
        } else {
            System.out.println("Invalid account type. Please try again.");
        }
    }
    

    private void deposit() {
        System.out.print("Type account ID\n>> ");
        String accountId = scanner.nextLine();
        System.out.print("Type Amount of money\n>> ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        transactionDepositService.deposit(accountId, amount);
        System.out.printf("%.2f$ transferred to %s account\n", amount, accountId);
    }

    private void withdraw() {
        System.out.print("Type account ID\n>> ");
        String accountId = scanner.nextLine();
        System.out.print("Type Amount of money\n>> ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        transactionWithdrawService.withdraw(accountId, amount);
        System.out.printf("%.2f$ transferred from %s account\n", amount, accountId);
    }

    private void transfer() {
    }
}
