public class PalindromeDemo {

    public static void main(String[] args) {
        String str = "abcb";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
