package org.myllds.mycache.evictionpolicy;

import org.myllds.mycache.evictionpolicy.structure.FrequencyMap;
import org.myllds.mycache.evictionpolicy.structure.Node;
import org.myllds.mycache.storage.CacheRecord;
import org.myllds.mycache.storage.CacheStorage;

import java.util.Map;

public class LFU<K, T> implements MyCacheEvictionPolicy<K, T>{

    private final CacheStorage<K, T> cacheStorage;
    private final FrequencyMap<K> frequencyMap;

    public LFU(CacheStorage<K, T> cacheStorage) {
        this.cacheStorage = cacheStorage;
        this.frequencyMap = new FrequencyMap<>();

    }
    @Override
    public void put(CacheRecord<K, T> cacheRecord, int capacity) {
    }

    @Override
    public CacheRecord<K, T> fetch(K key) {
        return null;
    }

}
