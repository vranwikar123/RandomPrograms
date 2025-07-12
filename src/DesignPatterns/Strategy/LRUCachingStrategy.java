package DesignPatterns.Strategy;

import java.util.Map;

public class LRUCachingStrategy implements ICacheStrategy{

    @Override
    public void strategy(Map<Integer, Integer> map) {
        System.out.println("LRUCachingStrategy");
    }
}
