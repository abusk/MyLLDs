package org.myllds.mycache.factory;

import org.myllds.mycache.evictionpolicy.EvictionPolicy;
import org.myllds.mycache.evictionpolicy.LRU;
import org.myllds.mycache.evictionpolicy.MyCacheEvictionPolicy;
import org.myllds.mycache.storage.CacheStorage;

public class EvictionPolicyFactory<K, T> {
    public MyCacheEvictionPolicy<K, T> getEvictionPolicy(CacheStorage<K, T> cacheStorage, EvictionPolicy evictionPolicy) {
        switch (evictionPolicy) {
            case LRU -> {
                return new LRU<>(cacheStorage);
            }
        }
        return null;
    }
}
