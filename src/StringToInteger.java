public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger st = new StringToInteger();
//        原字符串：42     转译后：42
//        原字符串：   -42     转译后：-42
//        原字符串：4193 with words     转译后：4193
//        原字符串：words and 987     转译后：0
//        原字符串：-91283472332     转译后：-2147483648
//        原字符串：+-2     转译后：0
//        原字符串：   +0 123     转译后：0
//        原字符串：-6147483648     转译后：-2147483648
//        原字符串：2147483648     转译后：2147483647
//        原字符串：-2147483649     转译后：-2147483648
        String[] s = {"42", "   -42", "4193 with words", "words and 987", "-91283472332", "+-2", "   +0 123", "-6147483648","2147483648","-2147483649"};
        for (String s1 : s) {
            System.out.println("原字符串：" + s1 + "     转译后：" + st.str2int(s1));
        }
    }

    private static int count = 0;
    private static int result = 0;
    private static boolean minus = false;

    private int str2int(String str) {
        count = 0;
        result = 0;
        minus = false;
        boolean nextCheckNumrical = false;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (count++ < 0) {
                break;
            }
            if (aChar >= 48 && aChar <= 57) {
                setResult(aChar - 48);
                nextCheckNumrical = true;
            } else {
                switch (aChar) {
                    case ' ':
                        if (nextCheckNumrical) {
                            count = -1;
                        }
                        break;
                    case '+':
                        if (nextCheckNumrical) {
                            count = -1;
                            result = 0;
                        } else {
                            nextCheckNumrical = true;
                        }
                        break;
                    case '-':
                        if (nextCheckNumrical) {
                            count = -1;
                            result = 0;
                        } else {
                            nextCheckNumrical = true;
                            minus = true;
                        }
                        break;
                    default:
                        count = -1;

                }
            }
        }
        return minus ? result * -1 : result;
    }

    private void setResult(int num) {
        int tempResult = result * 10 + num;
        if ((tempResult - num) / 10 != result || tempResult == Integer.MIN_VALUE || tempResult == -Integer.MAX_VALUE) {
            if (minus) {
                result = Math.abs(Integer.MIN_VALUE);
            } else {
                result = Integer.MAX_VALUE;
            }
            count = -1;
            return;
        }
        result = tempResult;
        count++;
    }
}
