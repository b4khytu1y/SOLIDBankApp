package com.bank.services;

import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;
import com.bank.models.Account;
import com.bank.models.Transaction;
@Service

public class TransactionWithdrawService {
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    public TransactionWithdrawService(AccountDAO accountDAO, TransactionDAO transactionDAO) {
        this.accountDAO = accountDAO;
        this.transactionDAO = transactionDAO;
    }

    public void withdraw(String accountId, double amount) {
        Account account = accountDAO.getAccount(accountId);
        account.withdraw(amount);
        accountDAO.saveAccount(account);
        Transaction transaction = new Transaction(accountId, amount, "WITHDRAW");
        transactionDAO.saveTransaction(transaction);
    }
}