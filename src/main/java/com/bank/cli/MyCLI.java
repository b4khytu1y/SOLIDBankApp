package com.bank.cli;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class MyCLI {
    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }
}
