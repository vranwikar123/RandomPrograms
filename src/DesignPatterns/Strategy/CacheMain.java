package DesignPatterns.Strategy;

import java.util.HashMap;
import java.util.Map;

public class CacheMain {

    private final Map<Integer, Integer> cacheMap;
    private final ICacheStrategy iCacheStrategy;
    CacheStratergyFactory cacheStratergyFactory;

    public CacheMain(String cacheStr)
    {
        cacheStratergyFactory = new CacheStratergyFactory();
        cacheMap = new HashMap<>();
        iCacheStrategy = cacheStratergyFactory.getCacheStratergy(cacheStr);
    }

    public void put(int key, int value)
    {
       System.out.println(" PUT called ");
       cacheMap.put(key, value);
       iCacheStrategy.strategy(cacheMap);
    }

    public Integer get(int key)
    {
        System.out.println(" GET called ");
        int k = cacheMap.get(key);
        iCacheStrategy.strategy(cacheMap);
        return k;
    }
}
