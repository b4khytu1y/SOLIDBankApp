package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;
import com.bank.models.Account;
import com.bank.models.Transaction;
@Service

public class TransactionDepositService {
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    public TransactionDepositService(AccountDAO accountDAO, TransactionDAO transactionDAO) {
        this.accountDAO = accountDAO;
        this.transactionDAO = transactionDAO;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.getAccount(accountNumber);
        account.deposit(amount);
        accountDAO.saveAccount(account);
        Transaction transaction = new Transaction(accountNumber, amount, "DEPOSIT");
        transactionDAO.saveTransaction(transaction);
    }
}