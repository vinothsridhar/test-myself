package in.sri.test.ds;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {

    private static class Node {
        String key;
        Object value;
        Node prev;
        Node next;

        Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int capacity = 2;
    private static Map<String, Node> map = new HashMap<>();
    private static Node head = new Node("", null);
    private static Node tail = new Node("", null);

    static {
        head.next = tail;
        tail.prev = head;
    }

    private static void addToFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private static void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void put(String key, Object value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() >= capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    private static Object get(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return null;
    }

    public static void main(String[] args) {
        put("a", 1);
        put("b", 2);
        System.out.println(get("a")); // Output: 1
        put("c", 3); // Evicts key "b"
        System.out.println(get("b")); // Output: null
        put("d", 4); // Evicts key "c"
        put("b", 2);
        System.out.println(get("c")); // Output: null
        System.out.println(get("d")); // Output: 4
        System.out.println(get("b")); // Output: 2
    }
}
