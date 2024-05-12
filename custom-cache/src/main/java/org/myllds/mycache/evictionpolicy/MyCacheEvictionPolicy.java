package org.myllds.mycache.evictionpolicy;

import org.myllds.mycache.exception.MyCacheInsertException;
import org.myllds.mycache.storage.CacheRecord;

public interface MyCacheEvictionPolicy<K, T> {
    void put(CacheRecord<K, T> cacheRecord, int capacity) throws MyCacheInsertException;
    CacheRecord<K, T> fetch(K key);
}
