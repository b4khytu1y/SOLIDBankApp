package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bank.service.AccountService;
import com.bank.util.ConsoleUtil;

@Controller
public class CLIController {

    @Autowired
    private AccountService accountService;

    public void run() {
        boolean running = true;
        while (running) {
            ConsoleUtil.printMainMenu();
            int choice = ConsoleUtil.getUserInput();

            switch (choice) {
                case 1:
                    accountService.listAccounts();
                    break;
                case 2:
                    accountService.createAccount();
                    break;
                case 3:
                    accountService.deposit();
                    break;
                case 4:
                    accountService.withdraw();
                    break;
                case 5:
                    accountService.transfer();
                    break;
                case 6:
                    ConsoleUtil.printMainMenu();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Application Closed");
    }
}