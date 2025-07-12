package DesignPatterns.Strategy;

import java.util.Map;

public class TTLCachingStrategy implements ICacheStrategy
{
    @Override
    public void strategy(Map<Integer, Integer> map)
    {
        System.out.println("TTL caching strategy");
    }
}
