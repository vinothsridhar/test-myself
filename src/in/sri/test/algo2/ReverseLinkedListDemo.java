public class ReverseLinkedListDemo {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add(new Node(1, null));
        list.add(new Node(2, null));
        list.add(new Node(3, null));
        list.add(new Node(4, null));

        print(list.first);

        reverseList(list.first);

    }

    static void reverseList(Node head) {
        Node current = head;
        Node next, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        print(head);
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class MyLinkedList {

        Node first;
        Node last;

        MyLinkedList() {}

        void add(Node element) {
            Node l = last;
            if (l == null) {
                first = element;
            } else {
                l.next = element;
            }
            last = element;
        }

    }

}
