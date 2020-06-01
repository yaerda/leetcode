import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String[] list = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] ans = {3, 4, 9, 58, 1994};
        for (int i = 0; i < list.length - 1; i++) {
            int count = count(list[i]);
            if (count != ans[i]) {
                System.out.println("Roman: " + list[i] + "   Ans:" + ans[i] + "    count:" + count);
            }
        }
    }

    private static final Map<Character, Integer> ROMAN = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    private static int count(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int pre = 10000;
        for (int i = 0; i < chars.length; i++) {
            int cur = ROMAN.get(chars[i]);
            if (cur > pre) {
                sum -= 2 * pre;
            }
            sum += cur;
            pre = cur;
        }
        return sum;
    }
}
