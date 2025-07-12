package DesignPatterns.RateLimiter;

public interface IRateLimiter {
    boolean isAllowed(UserRequest userRequest);
}
