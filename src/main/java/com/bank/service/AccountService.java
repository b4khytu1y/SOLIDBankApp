package com.bank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountDAO;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    // Получение всех аккаунтов клиента
    public List<Account> getAllAccounts(String clientID) {
        return accountDAO.findAllByClientId(clientID);
    }

    // Создание нового аккаунта для клиента
    public void createAccount(String clientID) {
        String accountId = UUID.randomUUID().toString();  // Генерация уникального идентификатора
        Account newAccount = new Account();
        newAccount.setId(accountId);
        newAccount.setClientId(clientID);
        newAccount.setBalance(0.0);  // Устанавливаем начальный баланс в 0

        accountDAO.save(newAccount);  // Сохранение нового аккаунта в базе данных
        System.out.println("New account created with ID: " + accountId);
    }
}
