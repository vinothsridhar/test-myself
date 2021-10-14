import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner obj = new Scanner(System.in);
            int T = obj.nextInt();
            obj.nextLine();
            while (T-- != 0) {
                String s = obj.nextLine();
                if (s.length() < 3) {
                    System.out.println("NO");
                    continue;
                }
                String first = s.substring(0, s.length() / 2);
                String second = s.substring(s.length() / 2 + 1, s.length());
                if (first.length() != second.length()) {
                    System.out.println("NO");
                    continue;
                }
                char[] fi = first.toCharArray();
                char[] se = second.toCharArray();
                Arrays.sort(fi);
                Arrays.sort(se);
                if (Arrays.toString(fi).compareTo(Arrays.toString(se)) == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            obj.close();
        } catch (Exception e) {
            return;
        }
    }
}

/*
 * 012345678910 aabcd aacbd len = 11 len/2 = 5
 * 
 */
