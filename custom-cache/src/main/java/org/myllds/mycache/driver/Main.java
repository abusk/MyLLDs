package org.myllds.mycache.driver;

import lombok.Builder;
import lombok.Data;
import org.myllds.mycache.MyCache;
import org.myllds.mycache.evictionpolicy.EvictionPolicy;
import org.myllds.mycache.exception.MyCacheMissException;

public class Main {
    public static void main(String[] args) throws MyCacheMissException {
        MyObject object = MyObject.builder().a(1).b(2.0f).c("m1").build();
        MyCache<String, MyObject> myCache = new MyCache<>(5, EvictionPolicy.LRU);
        myCache.put("k1", object);
        myCache.put("k2", object);
        myCache.put("k3", object);
        myCache.put("k4", object);
        myCache.put("k5", object);
        myCache.put("k1", object);
        myCache.put("k6", object);
        myCache.put("k2", object);
        myCache.put("k1", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k7", object);
        myCache.put("k8", object);
        myCache.put("k6", object);
        MyObject k1 = myCache.fetch("k1");
    }
}