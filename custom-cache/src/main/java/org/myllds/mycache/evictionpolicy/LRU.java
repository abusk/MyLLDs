package org.myllds.mycache.evictionpolicy;

import org.myllds.mycache.evictionpolicy.structure.DoubleLinkedList;
import org.myllds.mycache.evictionpolicy.structure.Node;
import org.myllds.mycache.storage.CacheRecord;
import org.myllds.mycache.storage.CacheStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class LRU<K, T> implements MyCacheEvictionPolicy<K, T>{

    private final CacheStorage<K, T> cacheStorage;
    private final Map<K, Node<K>> lruMap;
    private final DoubleLinkedList<K> dll;

    public LRU(CacheStorage<K, T> cacheStorage) {
        this.cacheStorage = cacheStorage;
        this.dll = new DoubleLinkedList<>();
        this.lruMap = new ConcurrentHashMap<>();
        for(CacheRecord<K, T> record : cacheStorage.getAllRecords()) {
            Node<K> newNode = new Node<>(record.getKey());
            Node<K> kNode = dll.addLast(newNode);
            lruMap.put(record.getKey(), kNode);
        }
    }

    @Override
    public void put(CacheRecord<K, T> cacheRecord, int capacity) {
        if(lruMap.containsKey(cacheRecord.getKey())) {
            Node<K> nodeToUpdate = lruMap.get(cacheRecord.getKey());
            dll.remove(nodeToUpdate);
        } else if (cacheStorage.getSize() >= capacity) {
            Node<K> kNode = dll.removeFirst();
            lruMap.remove(kNode.key);
            cacheStorage.removeItem(kNode.key);
        }
        Node<K> newNode = new Node<>(cacheRecord.getKey());
        Node<K> kNode = dll.addLast(newNode);
        lruMap.put(cacheRecord.getKey(), kNode);
        cacheStorage.addItem(cacheRecord);
    }

    @Override
    public CacheRecord<K, T> fetch(K key) {
        return cacheStorage.getItem(key);
    }

}
