package DesignPatterns.RateLimiter;

public interface IQuotaManager {
    void setUserQuota(String userId, int maxRequests);  // Configure user-based quotas
    void setEndpointRateLimiter(String endpoint, IRateLimiter rateLimiter);  // Configure endpoint-based rate limits
    boolean canProceed(UserRequest request);  // Checks if the request can be allowed
}
