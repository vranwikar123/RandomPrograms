package DesignPatterns.RateLimiter;

public class TokenBucketRateLimiter extends RateLimiter{
    private int tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int maxRequests, int timeWindow) {
        super(maxRequests, timeWindow);
        this.tokens = maxRequests;
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean isAllowed(UserRequest userRequest) {
        refillTokens();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refillTokens()
    {
        long currentTime = System.currentTimeMillis();
        long timeSinceLastRefill = currentTime - lastRefillTime;
        int refillCount = (int) (timeSinceLastRefill / 1000) * (maxRequests / timeWindow);
        tokens = Math.min(tokens + refillCount, maxRequests);
        lastRefillTime = currentTime;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public long getLastRefillTime() {
        return lastRefillTime;
    }

    public void setLastRefillTime(long lastRefillTime) {
        this.lastRefillTime = lastRefillTime;
    }
}
