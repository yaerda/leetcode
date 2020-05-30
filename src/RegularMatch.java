import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RegularMatch {
    public static void main(String[] args) {
        String[] str = {"aa", "aa", "ab", "aab", "mississippi"};
        String[] pattern = {"a", "a*", ".*", "c*a*b", "mis*is*p*."};
        boolean[] ansArray = {false, true, true, true, false};
        for (int i = 0; i < 5; i++) {
            boolean answer = isMatch5(str[i], pattern[i]);
            System.out.println(String.format("String: %s  Pattern: %s  return:%b answer:%b", str[i], pattern[i], answer, ansArray[i]));
        }
    }


    /**
     * 含*.的字符串动态规划
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch5(String s, String p) {
        dict = new HashMap<>();
        return dp(0, 0, s, p);
    }
    private static Map<String, Boolean> dict = new HashMap<>();

    private static boolean dp(int i, int j, String s, String p) {
        if (dict.get(i + "-" + j) != null) return dict.get(i + "-" + j);
        if (j == p.length()) return i == s.length();
        boolean firstCharMatch = i < s.length() && Arrays.asList(s.charAt(i), '.').contains(p.charAt(j));
        boolean ans;
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            ans = dp(i, j + 2, s, p) || (firstCharMatch && dp(i + 1, j, s, p));
        } else {
            boolean rest = dp(i + 1, j + 1, s, p);
            ans = firstCharMatch && rest;
        }
        dict.put(i + "-" + j, ans);
        return ans;
    }

    /**
     * 含*.的字符串递归匹配
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch4(String s, String p) {
        if (isEmpty(p)) return isEmpty(s);
        boolean starInSecond = p.length() >= 2 && p.charAt(1) == '*';
        if (starInSecond) {
            boolean zeroMatch = isMatch4(s, p.substring(2));
            boolean oneMatch = isMatch4(s.substring(1), p);
            return oneMatch || zeroMatch;
        } else {
            boolean firstChar = !isEmpty(s) && Arrays.asList(s.charAt(0), '.').contains(p.charAt(0));
            boolean noStar = isMatch4(s.substring(1), p.substring(1));
            return firstChar && noStar;
        }
    }

    /**
     * 含.的字符串递归匹配
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch3(String s, String p) {
        if (isEmpty(p)) return isEmpty(s);

        boolean firstChar = !isEmpty(s) && Arrays.asList(s.charAt(0), '.').contains(p.charAt(0));
        boolean rest = isMatch3(s.substring(1), p.substring(1));
        return firstChar && rest;
    }


    /**
     * 不含*.的字符串递归匹配
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch2(String s, String p) {
        if (isEmpty(p)) return isEmpty(s);

        boolean firstChar = !isEmpty(s) && s.charAt(0) == p.charAt(0);
        boolean rest = isMatch2(s.substring(1), p.substring(1));
        return firstChar && rest;
    }

    private static boolean isEmpty(String s) {
        return null == s || "".equals(s);
    }

    /**
     * 不含*.的字符串比对
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch1(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (j < p.length()) {
            if (i >= s.length()) {
                return false;
            }
            if (s.charAt(i++) != p.charAt(j++)) {
                return false;
            }
        }
        return j == p.length();
    }

}
