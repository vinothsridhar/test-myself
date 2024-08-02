import java.util.Arrays;

public class InsertionSortDemo {

    public static void main(String[] args) {

        int[] arr = new int[] { 3, 10, 4, -1, 7, 2};

        for (int i = 0; i < arr.length; i++) {
            sort(arr, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i) {
        while (i > 0 && arr[i] < arr[i - 1]) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            i--;
        }
    }

}
