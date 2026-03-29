package in.sri.test.ds;

public class DoublyLinkedList {

    private static class Node {
        Object value;
        Node prev;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private static Node head = new Node(null);
    private static Node tail = new Node(null);

    static {
        head.next = tail;
        tail.prev = head;
    }

    private static void addToFront(Object value) {
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    private static void addToEnd(Object value) {
        Node newNode = new Node(value);
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        newNode.next = tail;
    }

    private static void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void printList() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addToFront(1);
        addToFront(2);
        addToFront(3);
        addToEnd(4);
        printList(); // Output: 3 2 1

        removeNode(head.next); // Remove the first node (3)
        printList(); // Output: 2 1
    }

}
