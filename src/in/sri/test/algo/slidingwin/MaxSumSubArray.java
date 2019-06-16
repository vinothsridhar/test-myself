package in.sri.test.algo.slidingwin;

public class MaxSumSubArray {

    public static void main(String[] args) {
        
        int[] arr = {0, -3, 4, -1, -2, 1, -5, -3};
        
        int max_ending = 0;
        
        int max_so_far = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            max_ending = max_ending + arr[i];
            
            max_ending = Math.max(max_ending, 0);
            
            max_so_far = Math.max(max_so_far, max_ending);
            
        }
        
        System.out.println("max_so_far: " + max_so_far);
        
    }
    
}
