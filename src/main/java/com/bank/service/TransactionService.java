package com.bank.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountDAO;
import com.bank.repository.TransactionDAO;
import com.bank.util.ConsoleUtil;

@Service
public class TransactionService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    // Внесение денег на аккаунт
    public void deposit(String clientID) {
        String accountId = ConsoleUtil.askForAccountNumber();
        double amount = ConsoleUtil.askForAmount();

        Account account = accountDAO.findById(accountId).orElse(null);

        if (account != null && account.getClientId().equals(clientID)) {
            account.setBalance(account.getBalance() + amount);
            accountDAO.save(account);

            Transaction transaction = new Transaction();
            transaction.setId(UUID.randomUUID().toString());
            transaction.setAccountId(accountId);
            transaction.setAmount(amount);
            transactionDAO.save(transaction);

            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found or access denied.");
        }
    }

    // Снятие денег с аккаунта
    public void withdraw(String clientID) {
        String accountId = ConsoleUtil.askForAccountNumber();
        double amount = ConsoleUtil.askForAmount();

        Account account = accountDAO.findById(accountId).orElse(null);

        if (account != null && account.getClientId().equals(clientID)) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountDAO.save(account);

                Transaction transaction = new Transaction();
                transaction.setId(UUID.randomUUID().toString());
                transaction.setAccountId(accountId);
                transaction.setAmount(-amount);  // Отрицательное значение для снятия
                transactionDAO.save(transaction);

                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found or access denied.");
        }
    }
}
