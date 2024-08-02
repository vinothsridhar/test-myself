public class PrintSequenceCharsCountDemo {

    public static void main(String[] args) {
        String str = "aabcddkpqssr";
        printSequenceCharCount(str);
    }

    static void printSequenceCharCount(String s) {
        char[] chars = s.toCharArray();
        char prevChar = chars[0];
        int prevCharCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (prevChar == chars[i]) {
                prevCharCount++;
            } else {
                System.out.print(prevChar + "" + prevCharCount);
                prevChar = chars[i];
                prevCharCount = 1;
            }
        }
        System.out.print(prevChar + "" + prevCharCount);
    }

}
