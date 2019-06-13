package in.sri.test.algo;

import java.util.Arrays;

public class SumPair {

    public static void main(String[] args) {
        
        int[] arr = {1, 4, 7, 3, 6, 10, 2, 8};
        
        int k = 10;
        
        Arrays.sort(arr);
        
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            
            int sum = arr[left] + arr[right];
            
            if (sum == k) {
                
                System.out.println(String.format("pair(%d, %d) ", arr[left], arr[right]));
                
                left = left + 1;
                right = right - 1;
                
            }
            
            else if (sum < k) {
                left  = left + 1;
            }
            
            else if (sum > k) {
                right = right - 1;
            }
            
        }
        
    }
    
}
