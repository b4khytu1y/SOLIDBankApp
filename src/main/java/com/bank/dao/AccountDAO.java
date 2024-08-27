package com.bank.dao;

import java.util.List;

import com.bank.models.Account;

public interface AccountDAO {
    void addAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(String accountId);
}


//TODO
/*
 package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.bank.models.Account;

public class AccountDAO {

    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO Account (accountId, clientId, balance) VALUES (?, ?, ?)";
    private static final String SELECT_ACCOUNT_BY_NUMBER = "SELECT * FROM Account WHERE accountId = ?";

    public void save(Account account) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:bankdb", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.accountId());
            preparedStatement.setString(2, account.clientId());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Account> findByAccountId(String accountId) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:bankdb", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_NUMBER)) {
            preparedStatement.setString(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Account account = new Account(
                        rs.getString("accountId"),
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
 */