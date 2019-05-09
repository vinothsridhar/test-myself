package in.sri.test.tree;

public class BST {
    
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 6);
        root = insert(root, 20);
        root = insert(root, 4);
        System.out.println("tree: " + root);
        Node searched = search(root, 15);
        System.out.println("searched data: " + searched);
        try {
            System.out.println("min: " + findMin(root));
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            System.out.println("max: " + findMax(root));
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        levelOrder(root);
    }
    
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        levelOrder(root.getRight());
        System.out.print(" " + root.getData());
        levelOrder(root.getLeft());
    }
    
    public static Node findMin(Node root) throws CloneNotSupportedException {
        if (root == null) {
            return null;
        }
        
        Node current = (Node) root.clone();
        
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        
        return current;
    }
    
    public static Node findMax(Node root) throws CloneNotSupportedException {
        if (root == null) {
            return null;
        }
        
        Node current = (Node) root.clone();
        
        while (current.getRight() != null) {
            current = current.getRight();
        }
        
        return current;
    }
    
    public static Node search(Node root, int data) {
        if (root == null) {
            return null;
        }
        else if (root.getData() == data) {
            return root;
        }
        else if (root.getData() > data) {
            return search(root.getLeft(), data);
        }
        else if (root.getData() < data) {
            return search(root.getRight(), data);
        }
        else {
            return null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (root.getData() > data) {
            root.setLeft(insert(root.getLeft(), data));
        } else if (root.getData() < data) {
            root.setRight(insert(root.getRight(), data));
        }
        
        return root;
    }
    
    public static class Node implements Cloneable {
        
        private int data;
        
        private Node left;
        
        private Node right;
        
        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
