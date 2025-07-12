package DesignPatterns.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class QuotaManager {

    private Map<String, IRateLimiter> endpointLimiters = new HashMap<>();
    private Map<String, Integer> userQuotas = new HashMap<>();
    private Map<String, String> apiEndpoints = new HashMap<>(); // Added

    // Existing methods to set rate limiters and quotas

    // New method to register API endpoints
    public void registerApiEndpoint(String apiEndpoint, String endpoint) {
        apiEndpoints.put(apiEndpoint, endpoint);
    }

    // New method to register API endpoints
    public void setEndpointRateLimiter(String apiEndpoint, IRateLimiter rateLimiter) {
        endpointLimiters.put(apiEndpoint, rateLimiter);
    }


    // New method to retrieve the appropriate API endpoint
    public String getApiEndpoint(String apiEndpoint) {
        return apiEndpoints.get(apiEndpoint);
    }

    public boolean canProceed(UserRequest request) {
        IRateLimiter limiter = endpointLimiters.get(request.getEndpoint());
        if (limiter != null) {
            return limiter.isAllowed(request);
        }
        return false; // Deny if no rate limiter found
    }
}
