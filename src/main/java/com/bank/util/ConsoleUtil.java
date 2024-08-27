package com.bank.util;

import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine();
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
