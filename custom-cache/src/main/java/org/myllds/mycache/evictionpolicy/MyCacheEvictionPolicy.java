package org.myllds.mycache.evictionpolicy;

import org.myllds.mycache.storage.CacheRecord;

public interface MyCacheEvictionPolicy<K, T> {
    void put(CacheRecord<K, T> cacheRecord, int capacity);
    CacheRecord<K, T> fetch(K key);
}
