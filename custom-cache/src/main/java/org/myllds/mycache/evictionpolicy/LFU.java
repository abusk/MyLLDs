package org.myllds.mycache.evictionpolicy;

import org.myllds.mycache.storage.CacheRecord;

public class LFU<K, T> implements MyCacheEvictionPolicy<K, T>{

    @Override
    public void put(CacheRecord<K, T> cacheRecord, int capacity) {

    }

    @Override
    public CacheRecord<K, T> fetch(K key) {
        return null;
    }

}
