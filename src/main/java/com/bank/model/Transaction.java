package com.bank.model;

public class Transaction {
    private Long id;
    private Long accountId;
    private Double amount;
    private String transactionType;

    public Transaction() {}

    public Transaction(Long accountId, Double amount, String transactionType) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Getters and Setters
}