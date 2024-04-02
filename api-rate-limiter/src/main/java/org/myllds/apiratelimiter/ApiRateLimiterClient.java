package org.myllds.apiratelimiter;

import org.myllds.apiratelimiter.client.APIRequest;
import org.myllds.apiratelimiter.client.RateLimiterResponse;
import org.myllds.apiratelimiter.dao.StoreRequestInfoDao;
import org.myllds.apiratelimiter.dao.StoreRequestInfoImpl;
import org.myllds.apiratelimiter.service.RateLimitInfo;
import org.myllds.apiratelimiter.service.RateLimitManager;
import org.myllds.apiratelimiter.service.RateLimitRule;
import org.myllds.apiratelimiter.strategy.RateLimitStrategy;
import org.myllds.apiratelimiter.strategy.TokenBucketStrategy;

import java.util.ArrayList;

public class ApiRateLimiterClient {
    public static void main(String[] args) {
        RateLimitStrategy strategy = new TokenBucketStrategy();
        RateLimitRule rateLimitRule = new RateLimitRule();
        RateLimitInfo rateLimitInfo = new RateLimitInfo(strategy, rateLimitRule, new ArrayList<>());
        StoreRequestInfoDao requestInfoDao = new StoreRequestInfoImpl();
        RateLimitManager rateLimitManager = new RateLimitManager(rateLimitInfo, requestInfoDao);
        APIRequest apiRequest = new APIRequest();
        RateLimiterResponse rateLimiterResponse = rateLimitManager.processRequest(apiRequest);
    }
}
