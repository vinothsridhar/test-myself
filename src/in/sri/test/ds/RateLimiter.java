package in.sri.test.ds;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    private static int maxRequests = 5;
    private static long timeWindow = 1000; // 1 minute
    private static Map<String, RateLimiterNode> requestMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            if (isAllowed("user1")) {
                System.out.println("Request " + (i + 1) + " allowed for user1");
            } else {
                System.out.println("Request " + (i + 1) + " denied for user1");
            }
        }

        Thread.sleep(Duration.ofSeconds(1));

        for (int i = 0; i < 6; i++) {
            if (isAllowed("user2")) {
                System.out.println("Request " + (i + 1) + " allowed for user2");
            } else {
                System.out.println("Request " + (i + 1) + " denied for user2");
            }
        }

        for (int i = 0; i < 6; i++) {
            if (isAllowed("user1")) {
                System.out.println("Request " + (i + 1) + " allowed for user1");
            } else {
                System.out.println("Request " + (i + 1) + " denied for user1");
            }
        }
    }

    private static boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis();
        RateLimiterNode node = requestMap.computeIfAbsent(userId, k -> new RateLimiterNode(maxRequests));
        if (currentTime - node.timestamp > timeWindow) {
            System.out.println("Resetting count for user: " + userId);
            node.reset(maxRequests);
        }

        return isAllowedWithMaxRequest(node);
    }

    private static boolean isAllowedWithMaxRequest(RateLimiterNode node) {
        if (node.count-- > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static class RateLimiterNode {
        long timestamp;
        int count;

        RateLimiterNode(int maxRequests) {
            this.timestamp = System.currentTimeMillis();
            this.count = maxRequests;
        }

        void reset(int maxRequests) {
            this.timestamp = System.currentTimeMillis();
            this.count = maxRequests;
        }
    }

}
