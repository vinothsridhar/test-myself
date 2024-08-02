public class LongestPalindromeSubstringDemo {

    public static void main(String[] args) {
        String str = "abaa";
        System.out.println(findLongestPalindrome(str));
    }

    static String findLongestPalindrome(String str) {

        String maxStr = str.substring(0, 1);

        for (int i = 0; i < str.length() - 1; i++) {

            String odd = expandFromCenter(str, i, i);
            String even = expandFromCenter(str, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }

            if (even.length() > maxStr.length()) {
                maxStr = even;
            }

        }

        return maxStr;

    }

    static String expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        System.out.println("left: " + left + ", right: " + right + ", substring: " + str.substring(left + 1, right));
        return str.substring(left + 1, right);
    }

}
