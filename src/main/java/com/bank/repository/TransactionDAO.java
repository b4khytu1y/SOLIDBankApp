package com.bank.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bank.model.Transaction;

public class TransactionDAO {

    private static final String INSERT_TRANSACTION_SQL = "INSERT INTO Transaction (accountId, amount, transactionType) VALUES (?, ?, ?)";

    public void save(Transaction transaction) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:bankdb", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION_SQL)) {
            preparedStatement.setLong(1, transaction.getAccountId());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getTransactionType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}