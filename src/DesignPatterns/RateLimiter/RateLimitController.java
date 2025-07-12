package DesignPatterns.RateLimiter;

public class RateLimitController {

    private QuotaManager quotaManager;


    public RateLimitController(QuotaManager quotaManager) {
        this.quotaManager = quotaManager;
    }

    // Centralized function to handle requests
    public void handleRequest(UserRequest request) {
        boolean isAllowed = quotaManager.canProceed(request);

        // Log the request

        if (isAllowed) {
            // If allowed, forward request to API endpoint
            System.out.println("Request accepted");
        } else {
            System.out.println("Request rejected: Rate limit exceeded for " + request.getUserId());
        }
    }
}