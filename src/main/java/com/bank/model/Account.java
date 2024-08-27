package com.bank.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Account {

    @Id
    private String id;
    private String clientId;
    private double balance;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
