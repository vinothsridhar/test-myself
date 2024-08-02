public class MaxSumSubArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, -3, -10, 7, 4, 1, -12, 12, -22 };
        System.out.println(maxSubArray(arr));
    }

    static int maxSubArray(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
