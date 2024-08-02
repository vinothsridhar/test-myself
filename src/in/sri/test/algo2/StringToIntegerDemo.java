public class StringToIntegerDemo {

    public static void main(String[] args) {
        String str = "   -042";
        System.out.println(myAtoi(str));
    }

    static int myAtoi(String str) {
        int number = 0;
        boolean negative = false;
        int decimalIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '-') {
                negative = true;
                continue;
            }
            if (c == '0' && number == 0) {
                continue;
            }
            try {
                int value = Integer.parseInt(String.valueOf(c));
                number = (decimalIndex * 10 * number) + value;
                decimalIndex++;
            } catch(NumberFormatException e) {
                break;
            }
        }
        if (negative) {
            return number * -1;
        } else {
            return number;
        }
    }

}
