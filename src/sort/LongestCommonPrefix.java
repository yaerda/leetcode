package sort;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str1 = {"flower", "flow", "flight"};
        String[] str2 = {"dog", "racecar", "car"};
        String[] str3 = {};
        String[] str4 = {"a"};
        String[] str5 = {"aa", "a"};
        List<String[]> strsList = Arrays.asList(
                str1, str2, str3, str4, str5
        );
        for (String[] strings : strsList) {
            System.out.println(findLong2(strings));
        }
    }

    private static String findLong2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(pre)) pre = pre.substring(0, pre.length() - 1);
            if (pre.length() == 0) break;
        }
        return pre;
    }

    private static String findLong(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean canBreak = false;
        String firstStr = strs[0];
        int firstLen = firstStr.length();
        StringBuilder sBuilder = new StringBuilder();
        int i = 0;
        for (; i < firstLen; i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String curStr = strs[j];
                int curLen = curStr.length();
                canBreak = i >= curLen || curStr.charAt(i) != c;
                if (canBreak) {
                    break;
                }
            }
            if (canBreak) break;
            sBuilder.append(c);
        }
        return sBuilder.toString();
    }
}
