public class FindMaxProductArrayDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {-2,0,-1};

        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (leftProduct == 0) {
                leftProduct = 1;
            }
            if (rightProduct == 0) {
                rightProduct = 1;
            }

            leftProduct = leftProduct * arr[i];
            rightProduct = rightProduct * arr[arr.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }

        System.out.println(maxProduct);
    }

}
