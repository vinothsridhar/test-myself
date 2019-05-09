package in.sri.test.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        
        int[] arr = { 3, 4, 2, 5, 1, 7 };
        
        mergeSort(arr);
        
        System.out.println(Arrays.toString(arr));
    }
    
    public static void mergeSort(int[] arr) {
        
        if (arr.length < 2) {
            return;
        }
        
        int middle = arr.length / 2;
        
        int[] left = new int[middle];
        
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        
        int[] right = new int[arr.length - middle];
        
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[middle + i];
        }
        
        mergeSort(left);
        
        mergeSort(right);
        
        sort(left, right, arr);
        
    }
    
    public static void sort(int[] left, int[] right, int[] arr) {
        
        int i = 0;
        
        int j = 0;
        
        int k = 0;
        
        while (i < left.length && j < right.length) {
            
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            
            k++;
            
        }
        
        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }
        
        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
        
    }
    
}
