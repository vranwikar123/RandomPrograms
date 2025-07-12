package DesignPatterns.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class  FixedWindowRateLimiter extends RateLimiter{

    private Map<Long, Integer> requestCountPerWindow = new HashMap<>();

    public FixedWindowRateLimiter(int maxRequests, int timeWindow) {
        super(maxRequests, timeWindow);
    }

    @Override
    public synchronized boolean isAllowed(UserRequest userRequest) {
        long currentWindow = System.currentTimeMillis() / (timeWindow * 1000);
        requestCountPerWindow.putIfAbsent(currentWindow, 0);

        if (requestCountPerWindow.get(currentWindow) < maxRequests) {
            requestCountPerWindow.put(currentWindow, requestCountPerWindow.get(currentWindow) + 1);
            return true;
        }
        return false;
    }
}
