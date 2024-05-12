package org.myllds.mycache.driver;

import lombok.Builder;
import lombok.Data;
import org.myllds.mycache.MyCache;
import org.myllds.mycache.evictionpolicy.EvictionPolicy;
import org.myllds.mycache.exception.MyCacheInsertException;
import org.myllds.mycache.exception.MyCacheMissException;
import org.myllds.mycache.exception.MyCacheStorageException;

public class Main {
    public static void main(String[] args) throws MyCacheStorageException {
        MyObject object = MyObject.builder().a(1).b(2.0f).c("m1").build();
        MyCache<String, MyObject> myCache = new MyCache<>(5, EvictionPolicy.LRU);
        try {
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
        } catch (MyCacheInsertException e) {
            System.out.println(e.getMessage());
        }
        try {
            MyObject k1 = myCache.fetch("k1");
            MyObject k11 = myCache.fetch("k11");
        } catch (MyCacheMissException e) {
            System.out.println(e.getMessage());
        }

    }
}