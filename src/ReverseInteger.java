public class ReverseInteger {
    public static void main(String[] args) {
        int[] array = {123, -123, 120, 1646324359, -2147483648};
        for (int i : array) {
            System.out.println("iput: " + i + " output:" + reverse2(i));
            reverse(i);
        }
    }

    private static void reverse(Integer x) {
        if (x == Integer.MIN_VALUE) {
            System.out.println("iput: " + x + " output:" + 0);
            return;
        }
        boolean sub = x < 0;
        char[] inputChars = String.valueOf(Math.abs(x)).toCharArray();
        int len = inputChars.length;
        char[] outputChars = new char[len];
        for (int i = inputChars.length - 1, j = 0; i >= 0; i--) {
            char a = inputChars[i];
            if (a != '0') {
                outputChars[len - i - 1] = a;
                j++;
            }
        }
        String output = new String(outputChars);
        Long longInt = Long.valueOf(output.trim());
        Long maxInt = Long.valueOf(Integer.MAX_VALUE);
        if (maxInt < longInt) {
            output = "0";
        }
        output = (sub ? "-" : "") + output;
        System.out.println("iput: " + x + " output:" + Integer.valueOf(output.trim()));
    }

    private static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            int tempResult = result * 10 + temp;
            if ((tempResult - temp) / 10 != result) {
                return 0;
            }
            x = x / 10;
            result = tempResult;
        }
        return result;
    }
}

