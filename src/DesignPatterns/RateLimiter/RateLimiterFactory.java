package DesignPatterns.RateLimiter;

public class RateLimiterFactory
{
    public static IRateLimiter getRateLimiter(String type, int maxRequests, int timeWindow) {
        switch (type.toLowerCase()) {
            case "tokenbucket":
                return new TokenBucketRateLimiter(maxRequests, timeWindow);
            case "fixedwindow":
                return new FixedWindowRateLimiter(maxRequests, timeWindow);
            default:
                throw new IllegalArgumentException("Unknown rate limiter type");
        }
    }
}
