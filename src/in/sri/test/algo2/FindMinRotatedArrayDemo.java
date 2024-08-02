public class FindMinRotatedArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[] {3,4,5,1,2};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(arr[left]);
    }

}
