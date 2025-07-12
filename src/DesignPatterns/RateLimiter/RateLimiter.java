package DesignPatterns.RateLimiter;

public abstract class RateLimiter implements IRateLimiter
{
    protected int maxRequests;
    protected int timeWindow;

    public RateLimiter(int maxRequests, int timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
    }

    public abstract boolean isAllowed(UserRequest userRequest);
}
