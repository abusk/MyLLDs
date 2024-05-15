package org.myllds.splitwise.model;

public class Payer {
    private String payer;
    private double amount;

    public Payer(String payer, double amount) {
        this.payer = payer;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
