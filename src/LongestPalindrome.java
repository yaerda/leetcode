import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String[] s = {"ccc", "a", "abbc", "aba", "tattarrattat"};
        for (String s1 : s) {
            System.out.println("原字符串：" + s1 + "       palindrome:  " + solution(s1));
        }
    }

    private static String solution(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        String longest = String.valueOf(sChars[0]);
        for (int i = 0; i < sChars.length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int idx = map.get(c);
                int j = 1;
                String temp = "";
                if (i - idx == 1) {
                    int source = idx;
                    for (; i + j < sChars.length; j++) {
                        if (s.charAt(i + j) != c) {
                            break;
                        }
                    }
                    j--;
                    int m = 1;
                    for (; m + j + i < sChars.length; m++) {
                        if (idx - m < 0 || s.charAt(i + j + m) != s.charAt(idx - m)) {
                            break;
                        }
                    }
                    m--;
                    temp = s.substring(idx - m, i + j + m + 1);
                } else if (i - idx == 2) {
                    for (; i + j < sChars.length; j++) {
                        if (idx - j < 0 || s.charAt(i + j) != s.charAt(idx - j)) {
                            break;
                        }
                    }
                    j--;
                    temp = s.substring(idx - j, i + j + 1);
                }
                if (temp.length() > longest.length()) {
                    longest = temp;
                }
            }
            map.put(c, i);
        }
        return longest;
    }
}
