import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class GraphTraverseDemo {

    public static void main(String[] args) {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        v1.neighbours = Arrays.asList(v2, v4);
        v4.neighbours = Arrays.asList(v5, v6);
        v6.neighbours = Arrays.asList(v3, v2);
        v3.neighbours = List.of(v6);

//        traverse(v1);
        traverseStack(v1);
    }

    static void traverse(Vertex root) {
        System.out.println(" " + root.value);
        root.visited = true;
        root.neighbours.forEach(v -> {
            if (!v.visited) {
                traverse(v);
            }
        });
    }

    static void traverseStack(Vertex root) {
        System.out.println("traverseStack: ");
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex node = stack.pop();
            if (!node.visited) {
                node.visited = true;
                System.out.println(node.value);
                node.neighbours.forEach(stack::push);
            }
        }
    }

    static class Vertex {

        int value;
        List<Vertex> neighbours;
        boolean visited = false;

        Vertex(int value, List<Vertex> neighbours) {
            this.value = value;
            this.neighbours = new ArrayList<>(neighbours);
        }

        Vertex(int value) {
            this.value = value;
            this.neighbours = new ArrayList<>();
        }

    }

}
