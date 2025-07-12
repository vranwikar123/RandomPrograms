package DesignPatterns.RateLimiter;

public class Main {
    public static void main(String[] args) {
        QuotaManager quotaManager = new QuotaManager();
        RateLimitController controller = new RateLimitController(quotaManager);

        // Step 2: Configure API Endpoints with Rate Limiters (Quota Management Workflow)
        IRateLimiter freeTierRateLimiter = RateLimiterFactory.getRateLimiter("tokenbucket", 100, 3600);  // Free user: Token Bucket
        IRateLimiter premiumTierRateLimiter = RateLimiterFactory.getRateLimiter("fixedwindow", 1000, 3600);  // Premium user: Fixed Window

        quotaManager.setEndpointRateLimiter("/api/resource-free", freeTierRateLimiter);
        quotaManager.setEndpointRateLimiter("/api/resource-premium", premiumTierRateLimiter);

        UserRequest freeUserRequest = new UserRequest("user-free", "/api/resource-free");
        UserRequest premiumUserRequest = new UserRequest("user-premium", "/api/resource-premium");

        controller.handleRequest(freeUserRequest);
        controller.handleRequest(premiumUserRequest);
    }
}
