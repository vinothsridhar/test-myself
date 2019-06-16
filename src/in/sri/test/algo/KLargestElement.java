package in.sri.test.algo;

import java.util.PriorityQueue;

public class KLargestElement {

    public static void main(String[] args) {
        
        int[] arr = {1, 23, 8, 2, 34, 89, 12, 14};
        
        int klargest = 2;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > klargest) {
                queue.remove();
            }
        }
        
        while (queue.isEmpty() == false) {
            System.out.println(queue.remove());
        }
        
    }
    
}
