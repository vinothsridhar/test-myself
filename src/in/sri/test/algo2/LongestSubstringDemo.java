import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringDemo {

    public static void main(String[] args) {
        System.out.println(longestSubstring("ab"));
    }

    static int longestSubstring(String s) {

        int start = 0, end = 0;

        Set<Character> result = new LinkedHashSet<>();

        int length = Math.min(s.length(), 1);

        int left = 0, right = 0;

        while (end < s.length()) {

            char c = s.charAt(end);

            while (result.contains(c)) {
                result.remove(s.charAt(start));
                start++;
            }

            result.add(c);

            int tempLength = end - start + 1;

            if (tempLength > length) {
                length = tempLength;
                left = start;
                right = end;
            }

            end++;

        }

        while (left <= right) {
            System.out.print(s.charAt(left));
            left++;
        }

        System.out.println();

        return length;

    }

}
