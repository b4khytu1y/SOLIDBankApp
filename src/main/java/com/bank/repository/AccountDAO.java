package com.bank.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bank.model.Account;
@Repository
    public class AccountDAO {
    
        private static final String INSERT_ACCOUNT_SQL = "INSERT INTO Account (accountNumber, clientId, balance) VALUES (?, ?, ?)";
        private static final String SELECT_ACCOUNT_BY_NUMBER = "SELECT * FROM Account WHERE accountNumber = ?";
    
        public void save(Account account) {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:bankdb", "demoon", "123");
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
                preparedStatement.setString(1, account.getAccountNumber());
                preparedStatement.setString(2, account.getClientId());
                preparedStatement.setDouble(3, account.getBalance());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public Optional<Account> findByAccountNumber(String accountNumber) {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:bankdb", "demoon", "123");
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_NUMBER)) {
                preparedStatement.setString(1, accountNumber);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    Account account = new Account(
                            rs.getString("accountNumber"),
                            rs.getString("clientId"),
                            rs.getDouble("balance")
                    );
                    return Optional.of(account);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }
    }