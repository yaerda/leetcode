import java.util.HashMap;
import java.util.Map;

class LongestSubstring {
    public static void main(String[] args) {
        log("The ：" + find("diuadhadjoadjoancniaod"));
    }

    private static int find(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char jc = s.charAt(j);
            if (charIdxMap.containsKey(jc)) {
                i = Math.max(charIdxMap.get(jc) + 1, i);
            }
            charIdxMap.put(jc, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    static void log(String s) {
        System.out.println(s);
    }
}
