package org.myllds.mycache.evictionpolicy.structure;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FrequencyMap <K>{
    private final Map<Integer, LinkedHashSet<K>> frequencyMap;
    private AtomicInteger minFrequency;

    public FrequencyMap() {
        frequencyMap = new ConcurrentHashMap<>();
        minFrequency =  new AtomicInteger(1);
    }

    public void addItem(int fre, K key) {
        if(frequencyMap.containsKey(fre)) {
            LinkedHashSet<K> ks = frequencyMap.get(fre);
            ks.remove(key);
            if(ks.isEmpty()) {
                frequencyMap.remove(key);
                if (fre == minFrequency.get()) {
                    minFrequency.incrementAndGet();
                }
            }
            frequencyMap.getOrDefault(fre+1, new LinkedHashSet<>()).add(key);
        } else {
            minFrequency.set(fre);
            LinkedHashSet<K> ls = new LinkedHashSet<>();
            ls.add(key);
            frequencyMap.put(fre, ls);
        }
    }

    public void getItem() {

    }
}
