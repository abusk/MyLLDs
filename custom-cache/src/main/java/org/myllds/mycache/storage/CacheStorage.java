package org.myllds.mycache.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheStorage <K, T> {
    private final Map<K, CacheRecord<K, T>> cacheStore;
    public CacheStorage(int capacity) {
        this.cacheStore = new ConcurrentHashMap<>(capacity);
    }

    public void addItem(CacheRecord<K, T> record) {
        cacheStore.put(record.getKey(), record);
    }
    public CacheRecord<K, T> getItem(K key) {
        return cacheStore.get(key);
    }

    public boolean ifItemExists(K key) {
        return cacheStore.containsKey(key);
    }

    public void removeItem(K key) {
        cacheStore.remove(key);
    }

    public void updateSize(int size) {

    }

    public int getSize() {
        return cacheStore.size();
    }
    public List<CacheRecord<K, T>> getAllRecords() {
        return new ArrayList<>(cacheStore.values());
    }
}
