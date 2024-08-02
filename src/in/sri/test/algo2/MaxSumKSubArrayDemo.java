public class MaxSumKSubArrayDemo {

    public static void main(String[] args) {

        int[] arr = new int[] { 2, 4, -3, 7, 4, 1, -5, 12 };

        int k = 3;

        System.out.println(maxSumSubArray(arr, k));

    }

    static int maxSumSubArray(int[] arr, int k) {

        int start = 0, end = 0, maxSum = 0, windowSum = 0;

        while (end < k) {
            windowSum += arr[end++];
        }

        while (end < arr.length) {
            windowSum += (arr[end++] - arr[start++]);
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

}
