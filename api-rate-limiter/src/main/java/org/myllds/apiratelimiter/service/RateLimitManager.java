package org.myllds.apiratelimiter.service;

import org.myllds.apiratelimiter.client.APIRequest;
import org.myllds.apiratelimiter.client.RateLimiterResponse;
import org.myllds.apiratelimiter.dao.StoreRequestInfoDao;

public class RateLimitManager {
    private final RateLimitInfo rateLimitInfo;
    private final RateLimiter rateLimiter;
    private final StoreRequestInfoDao storeRequestInfoDao;

    public RateLimitManager(RateLimitInfo rateLimitInfo, StoreRequestInfoDao storeRequestInfoDao) {
        this.rateLimitInfo = rateLimitInfo;
        this.rateLimiter = new RateLimiter(rateLimitInfo.getRateLimitStrategy(), rateLimitInfo.getRateLimitRule().getRate());
        this.storeRequestInfoDao = storeRequestInfoDao;
    }
    public RateLimiterResponse processRequest(APIRequest apiRequest) {
        RateLimiterResponse response = rateLimiter.execute(apiRequest.getApiUrl(), apiRequest.getClient().getApiKey());
        return response;
    }
}
