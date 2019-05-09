package in.sri.test.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = { 3, 4, 2, 5, 1, 7 };

        for (int i = 0; i < arr.length; i++) {

            sort(arr, i);

        }

        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int pos) {

        int i = pos;

        while (i > 0 && arr[i] < arr[i - 1]) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            i--;
        }

    }

}
