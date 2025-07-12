package DesignPatterns.Strategy;

public class CacheStratergyFactory {

    private ICacheStrategy cacheStrategy;

    public ICacheStrategy getCacheStratergy(String cacheStrategyStr)
    {
        switch (cacheStrategyStr)
        {
            case "LRU":
                cacheStrategy = new LRUCachingStrategy();
                break;
            case "TTL":
                cacheStrategy = new TTLCachingStrategy();
                break;
            default:
                cacheStrategy = new LRUCachingStrategy();
        }

        return cacheStrategy;
    }
}
