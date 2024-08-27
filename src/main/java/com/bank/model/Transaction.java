package com.bank.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Transaction {

    @Id
    private String id;
    private String accountId;
    private double amount;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
