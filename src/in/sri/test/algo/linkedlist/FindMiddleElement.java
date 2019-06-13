package in.sri.test.algo.linkedlist;

public class FindMiddleElement {

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
        
        //traverse
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        
        //find middle element
        current = head;
        Node middle = head;
        int length = 0;
        while (current.next != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next;
            }
            
            current = current.next;
        }
        
        if (length % 2 == 1) {
            middle = middle.next;
        }
        
        System.out.println("middle element: " + middle.value);
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
