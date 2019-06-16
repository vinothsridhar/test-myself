package in.sri.test.algo.slidingwin;

public class MaxSubArray {

    public static void main(String args[]) {
        
        int[] arr = {1, 1, 1, 0, 1, 1, 1, 1};
        
        int total_zero = 0;
        
        int max_diff = 0;
        
        int current_diff = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == 0) {
                total_zero++;
            }
            
            int value = arr[i] == 1 ? 1 : -1;
            
            current_diff = Math.max(value, current_diff + value);
            
            max_diff = Math.max(current_diff, max_diff);
            
        }
        
        max_diff = Math.max(max_diff, 0);
        
        System.out.println(max_diff + total_zero);
        
    }
    
    
    
}
