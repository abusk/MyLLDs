package org.myllds.stockalert.model;

public class StockData {
    private String company;
    private double price;
    private int nb_shares;
    private long timestamp;

    public StockData(String company, double price, int nb_shares, long timestamp) {
        this.company = company;
        this.price = price;
        this.nb_shares = nb_shares;
        this.timestamp = timestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNb_shares() {
        return nb_shares;
    }

    public void setNb_shares(int nb_shares) {
        this.nb_shares = nb_shares;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
