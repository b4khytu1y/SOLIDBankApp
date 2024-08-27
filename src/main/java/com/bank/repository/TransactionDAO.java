package com.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Transaction;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, String> {
    // Custom query methods can be added here
}
