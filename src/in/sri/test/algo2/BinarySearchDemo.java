import java.util.Arrays;

public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] arr = new int[] { 8, 2, 5, 9, 1, 3, 7 };
        int value = 7;

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int index = search(arr, 0, arr.length - 1, value);
        System.out.println("found at index: " + index);

    }

    static int search(int[] arr, int left, int right, int value) {

        if (right >= left) {

            int middle = (left + right) / 2;

            if (value == arr[middle]) {
                return middle;
            }

            if (arr[middle] > value) {
                return search(arr, left, middle - 1, value);
            } else {
                return search(arr, middle + 1, right, value);
            }

        }

        return -1;
    }

}
