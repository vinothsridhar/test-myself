public class BSTDemo {

    public static void main(String[] args) {

        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(6);
        tree.insert(12);
        tree.insert(3);
        tree.insert(8);
        tree.insert(20);
        tree.insert(30);
        tree.insert(1);

//        traverseInOrder(tree.root);

        boolean found = search(tree.root, 3);
        System.out.println("Found value: " + found);

    }


    static boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        if (root.value < value) {
            return search(root.right, value);
        } else {
            return search(root.left, value);
        }
    }

    static void traversePreOrder(Node root) {
        if (root != null) {
            System.out.print(" " + root.value);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    static void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.print(" " + root.value);
            traverseInOrder(root.right);
        }
    }

    static class Node {

        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(int value) {
            this.value = value;
        }

    }

    static class MyBinaryTree {
        Node root;

        void insert(int value) {
            this.root = insert(this.root, value);
        }

        private static Node insert(Node root, int value) {
            if (root == null) {
                root = new Node(value);
            } else if (root.value > value) {
                root.left = insert(root.left, value);
            } else {
                root.right = insert(root.right, value);
            }

            return root;
        }

    }

}