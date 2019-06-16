package in.sri.test.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElement {

    public static void main(String[] args) {
        
        int[] arr = {1, 23, 8, 2, 34, 89, 12, 14};
        
        int ksmallest = 3;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > ksmallest) {
                queue.remove();
            }
        }
        
        while (queue.isEmpty() == false) {
            System.out.println(queue.remove());
        }
        
    }
    
}
