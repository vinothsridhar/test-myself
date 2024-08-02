public class SearchRotatedSortedArrayDemo {

    public static void main(String[] args) {
        int[] nums = new int[] { 4,5,6,7,0,1,2 };
        System.out.println(search(nums, 0));
    }

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
