package in.sri.test.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        
        int[] arr = {3, 4, 2, 5, 1, 7};
        
        for (int i = 0; i < arr.length; i++) {
            
            boolean sorted = true;
            
            for (int j = 0; j < arr.length - i - 1; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    sorted = false;
                }
                
            }
            
            if (sorted) {
                System.out.println("sorted at: " + i);
                break;
            }
            
        }
        
        System.out.println(Arrays.toString(arr));
        
    }
    
}
