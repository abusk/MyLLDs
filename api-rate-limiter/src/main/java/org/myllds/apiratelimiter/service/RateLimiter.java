package org.myllds.apiratelimiter.service;

import org.myllds.apiratelimiter.client.RateLimiterResponse;
import org.myllds.apiratelimiter.strategy.RateLimitStrategy;

public class RateLimiter {
    private final int rate;
    private final RateLimitStrategy strategy;

    public RateLimiter(RateLimitStrategy strategy, int rate) {
        this.rate = rate;
        this.strategy = strategy;
    }
    RateLimiterResponse execute(String api, String clientKey) {
        int code = strategy.execute(api, rate, clientKey);
        return new RateLimiterResponse();
    }

    public int getRate() {
        return rate;
    }

    public RateLimitStrategy getStrategy() {
        return strategy;
    }
}
