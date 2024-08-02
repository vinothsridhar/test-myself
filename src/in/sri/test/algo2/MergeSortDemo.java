import java.util.Arrays;

public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 2, 5, 9, 1, 3, 7 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int middle = arr.length / 2;
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];
        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0, arr.length - middle);
        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
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
