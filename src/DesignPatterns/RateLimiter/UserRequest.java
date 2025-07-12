package DesignPatterns.RateLimiter;

public class UserRequest {
    private String userId;
    private String endpoint;
    private long timestamp;

    public UserRequest(String userId, String endpoint) {
        this.userId = userId;
        this.endpoint = endpoint;
        this.timestamp = System.currentTimeMillis();
    }

    public String getUserId() { return userId; }
    public String getEndpoint() { return endpoint; }
    public long getTimestamp() { return timestamp; }
}
