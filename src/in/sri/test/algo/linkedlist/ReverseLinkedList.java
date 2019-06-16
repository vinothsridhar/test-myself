package in.sri.test.algo.linkedlist;

public class ReverseLinkedList {
    
    public static void main(String[] args) {
        
        Node head = new Node(1, null);
        Node tail = head;
        
        tail.next = new Node(2, null);
        tail = tail.next;
        
        tail.next = new Node(3, null);
        tail = tail.next;
        
        tail.next = new Node(4, null);
        tail = tail.next;
        
        tail.next = new Node(5, null);
        tail = tail.next;
        
        Node current = head;
        Node prev = null, next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        
    }

    private static class Node {
        private int value;
        private Node next;
        
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
}
