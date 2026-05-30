import java.security.MessageDigest;
import java.util.*;

class RedisNode {
    String name;

    RedisNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ConsistentHashRing {
    private final TreeMap<Integer, RedisNode> ring = new TreeMap<>();
    private final int virtualNodes;

    ConsistentHashRing(int virtualNodes) {
        this.virtualNodes = virtualNodes;
    }

    public void addNode(RedisNode node) {
        for (int i = 0; i < virtualNodes; i++) {
            String virtualNodeName = node.name + "#" + i;
            int position = hash(virtualNodeName);
            ring.put(position, node);
        }
    }

    public RedisNode getNode(String key) {
        int keyHash = hash(key);

        Map.Entry<Integer, RedisNode> entry = ring.ceilingEntry(keyHash);

        // If key is after the last node, wrap to first node
        if (entry == null) {
            entry = ring.firstEntry();
        }

        return entry.getValue();
    }

    private int hash(String value) {
        return Math.abs(value.hashCode());
    }
}

public class Main {
    public static void main(String[] args) {
        ConsistentHashRing ring = new ConsistentHashRing(5);

        RedisNode redisA = new RedisNode("Redis-A");
        RedisNode redisB = new RedisNode("Redis-B");
        RedisNode redisC = new RedisNode("Redis-C");

        ring.addNode(redisA);
        ring.addNode(redisB);
        ring.addNode(redisC);

        List<String> keys = List.of(
                "user:1001",
                "user:1002",
                "session:abc",
                "cart:55",
                "product:900"
        );

        System.out.println("Initial mapping:");
        for (String key : keys) {
            System.out.println(key + " -> " + ring.getNode(key));
        }

        System.out.println("\nAfter adding Redis-D:");

        RedisNode redisD = new RedisNode("Redis-D");
        ring.addNode(redisD);

        for (String key : keys) {
            System.out.println(key + " -> " + ring.getNode(key));
        }
    }
}


/* 
OUTPUT
--------

Initial mapping:
user:1001 -> Redis-B
user:1002 -> Redis-C
session:abc -> Redis-A
cart:55 -> Redis-B
product:900 -> Redis-C

After adding Redis-D:
user:1001 -> Redis-B
user:1002 -> Redis-D
session:abc -> Redis-A
cart:55 -> Redis-B
product:900 -> Redis-C
*/
