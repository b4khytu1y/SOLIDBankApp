package com.bank.model;

public class Account {
    private Long id;
    private String accountNumber;
    private String clientId;
    private Double balance;

    public Account() {}

    public Account(String accountNumber, String clientId, Double balance) {
        this.accountNumber = accountNumber;
        this.clientId = clientId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // Getters and Setters
}