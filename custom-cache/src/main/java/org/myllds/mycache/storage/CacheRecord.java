package org.myllds.mycache.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheRecord <K, T>{
    private K key;
    private T value;
    private int frequency;
    private long timestamp;
}
