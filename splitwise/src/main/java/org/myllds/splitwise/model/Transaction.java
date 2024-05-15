package org.myllds.splitwise.model;

import java.util.List;

public class Transaction {
    private User provider;
    double amount;
    int numberOfUser;
    List<User> users;
    TransactionType type;
    List<Double> shares;

    public Transaction(User provider, double amount, int numberOfUser, List<User> users, TransactionType type, List<Double> shares) {
        this.provider = provider;
        this.amount = amount;
        this.numberOfUser = numberOfUser;
        this.users = users;
        this.type = type;
        this.shares = shares;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumberOfUser() {
        return numberOfUser;
    }

    public void setNumberOfUser(int numberOfUser) {
        this.numberOfUser = numberOfUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public List<Double> getShares() {
        return shares;
    }

    public void setShares(List<Double> shares) {
        this.shares = shares;
    }
}
