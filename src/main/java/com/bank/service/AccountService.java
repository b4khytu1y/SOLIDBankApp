package com.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountDAO;
import com.bank.repository.TransactionDAO;
import com.bank.util.ConsoleUtil;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    public void listAccounts() {
        // Здесь можно реализовать логику для вывода всех счетов
    }

    public void createAccount() {
        String accountType = ConsoleUtil.askForAccountType();
        String accountNumber = String.format("%03d%06d", 1, (int) (Math.random() * 1000000));
        Account account = new Account(accountNumber, "1", 0.0);
        accountDAO.save(account);
        System.out.println("Bank account created");
    }

    public void deposit() {
        String accountNumber = ConsoleUtil.askForAccountNumber();
        Optional<Account> optionalAccount = accountDAO.findByAccountNumber(accountNumber);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            double amount = ConsoleUtil.askForAmount();
            account.setBalance(account.getBalance() + amount);
            accountDAO.save(account);
            transactionDAO.save(new Transaction(account.getId(), amount, "DEPOSIT"));
            System.out.println(amount + "$ transferred to " + accountNumber + " account");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        String accountNumber = ConsoleUtil.askForAccountNumber();
        Optional<Account> optionalAccount = accountDAO.findByAccountNumber(accountNumber);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            double amount = ConsoleUtil.askForAmount();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountDAO.save(account);
                transactionDAO.save(new Transaction(account.getId(), amount, "WITHDRAW"));
                System.out.println(amount + "$ transferred from " + accountNumber + " account");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer() {
        // Реализуйте логику перевода денег между счетами
    }
}