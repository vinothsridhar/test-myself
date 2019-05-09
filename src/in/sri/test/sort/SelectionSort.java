package in.sri.test.sort;

import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 1, 7};
        
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int index = i;
            while (j < arr.length) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
                j++;
            }
            
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        
        System.out.println(Arrays.toString(arr));
    }

}
