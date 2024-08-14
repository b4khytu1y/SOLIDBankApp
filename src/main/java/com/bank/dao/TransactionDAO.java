package com.bank.dao;

import java.util.List;

import com.bank.models.Transaction;


public interface TransactionDAO {
    void saveTransaction(Transaction transaction);
    List<Transaction> getTransactions(String accountId);
}