package org.myllds.apiratelimiter.service;

import org.myllds.apiratelimiter.strategy.RateLimitStrategy;

import java.util.List;

public class RateLimitInfo {
    private List<String> apiList;
    private RateLimitStrategy rateLimitStrategy;
    private RateLimitRule rateLimitRule;

    public RateLimitInfo(RateLimitStrategy rateLimitStrategy, RateLimitRule rateLimitRule, List<String> apiList) {
        this.rateLimitStrategy = rateLimitStrategy;
        this.rateLimitRule = rateLimitRule;
        this.apiList = apiList;
    }
    public List<String> getApiList() {
        return apiList;
    }

    public void setApiList(List<String> apiList) {
        this.apiList = apiList;
    }

    public RateLimitStrategy getRateLimitStrategy() {
        return rateLimitStrategy;
    }

    public void setRateLimitStrategy(RateLimitStrategy rateLimitStrategy) {
        this.rateLimitStrategy = rateLimitStrategy;
    }

    public RateLimitRule getRateLimitRule() {
        return rateLimitRule;
    }

    public void setRateLimitRule(RateLimitRule rateLimitRule) {
        this.rateLimitRule = rateLimitRule;
    }
}
