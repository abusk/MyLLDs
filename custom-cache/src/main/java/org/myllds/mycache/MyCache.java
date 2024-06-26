package org.myllds.mycache;

import org.myllds.mycache.evictionpolicy.EvictionPolicy;
import org.myllds.mycache.exception.MyCacheInsertException;
import org.myllds.mycache.exception.MyCacheMissException;
import org.myllds.mycache.exception.MyCacheStorageException;
import org.myllds.mycache.factory.EvictionPolicyFactory;
import org.myllds.mycache.evictionpolicy.MyCacheEvictionPolicy;
import org.myllds.mycache.storage.CacheRecord;
import org.myllds.mycache.storage.CacheStorage;

public class MyCache<K, T> {
    private int size;
    private CacheStorage<K, T> cacheStorage;
    private MyCacheEvictionPolicy<K, T> myCacheEvictionPolicy;

    public MyCache() {
        this.size = 5;
        cacheStorage = new CacheStorage<>(this.size);
        EvictionPolicyFactory<K, T> factory = new EvictionPolicyFactory<>();
        myCacheEvictionPolicy = factory.getEvictionPolicy(cacheStorage, EvictionPolicy.LRU);
    }
    public MyCache(int size) throws MyCacheStorageException {
        this.size = size;
        if (size <= 0) {
            throw new MyCacheStorageException("Cache capacity should not be <= 0");
        }
        cacheStorage = new CacheStorage<>(this.size);
        EvictionPolicyFactory<K, T> factory = new EvictionPolicyFactory<>();
        myCacheEvictionPolicy = factory.getEvictionPolicy(cacheStorage, EvictionPolicy.LRU);
    }

    public MyCache(int size, EvictionPolicy evictionPolicy) throws MyCacheStorageException {
        this.size = size;
        if (size <= 0) {
            throw new MyCacheStorageException("Cache capacity should not be <= 0");
        }
        cacheStorage = new CacheStorage<>(this.size);
        EvictionPolicyFactory<K, T> factory = new EvictionPolicyFactory<>();
        myCacheEvictionPolicy = factory.getEvictionPolicy(cacheStorage,evictionPolicy);

    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        EvictionPolicyFactory<K, T> factory = new EvictionPolicyFactory<>();
        myCacheEvictionPolicy = factory.getEvictionPolicy(cacheStorage,evictionPolicy);
    }

    public void setCacheSize(int size) throws MyCacheStorageException {
        if (size <= 0) {
            throw new MyCacheStorageException("Cache capacity should not be <= 0");
        }
        this.size = size;
    }

    public void put(K key, T item) throws MyCacheInsertException {
        int count = 1;
        if(cacheStorage.ifItemExists(key)) {
            count += cacheStorage.getItem(key).getFrequency();
        }
        CacheRecord<K, T> record = new CacheRecord<>(key, item, count, System.currentTimeMillis());
        myCacheEvictionPolicy.put(record, this.size);
    }

    public T fetch(K key) throws MyCacheMissException {
        CacheRecord<K, T> fetch = myCacheEvictionPolicy.fetch(key);
        if(fetch == null) {
            throw new MyCacheMissException("Cache Miss: Item:" +key+ " not found in cache:");
        }
        return fetch.getValue();
    }

    public void cleanCache() {

    }
}
