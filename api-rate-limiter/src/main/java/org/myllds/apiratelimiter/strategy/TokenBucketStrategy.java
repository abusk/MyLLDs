package org.myllds.apiratelimiter.strategy;

import org.myllds.apiratelimiter.client.Status;

public class TokenBucketStrategy implements RateLimitStrategy {
    @Override
    public int execute(String api, int rate, String clientKey) {
        System.out.println("TokenBucketStrategy executed");
        return Status.LIMITED.getCode();
    }
}
