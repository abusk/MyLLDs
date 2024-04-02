package org.myllds.apiratelimiter.service;

public class RateLimitRule {
    private String type;
    private int rate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
