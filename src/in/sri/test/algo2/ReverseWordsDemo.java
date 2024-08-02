import java.util.Stack;

public class ReverseWordsDemo {

    public static void main(String[] args) {
        String words = "  hello  world  ";
        System.out.println(reverseWords(words));
    }

    static String reverseWords(String s) {

        Stack<String> stack = new Stack<>();

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            if (aChar == ' ') {
                stack.push(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(aChar);
            }
        }

        stack.push(sb.toString());

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            String word = stack.pop().trim();
            if (!word.isEmpty()) {
                reversed.append(word).append(" ");
            }
        }
        reversed.deleteCharAt(reversed.length() - 1);
        return reversed.toString();
    }

}
