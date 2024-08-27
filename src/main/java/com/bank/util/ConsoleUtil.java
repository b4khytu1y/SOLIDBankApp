package com.bank.util;

import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMainMenu() {
        System.out.println("Welcome to CLI bank service");
        System.out.println("Enter operation number:");
        System.out.println("1 - show accounts");
        System.out.println("2 - create new account");
        System.out.println("3 - deposit money");
        System.out.println("4 - withdraw money");
        System.out.println("5 - transfer money");
        System.out.println("6 - print menu");
        System.out.println("7 - exit");
    }

    public static int getUserInput() {
        return scanner.nextInt();
    }

    public static String askForAccountNumber() {
        System.out.println("Enter account number:");
        return scanner.next();
    }

    public static double askForAmount() {
        System.out.println("Enter amount:");
        return scanner.nextDouble();
    }

    public static String askForAccountType() {
        System.out.println("Enter account type:");
        return scanner.next();
    }
}