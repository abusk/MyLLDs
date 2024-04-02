package org.myllds.apiratelimiter.strategy;

public interface RateLimitStrategy {
   int execute(String api, int rate, String clientKey);
}
