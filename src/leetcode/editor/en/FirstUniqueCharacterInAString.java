//Given a string s, find the first non-repeating character in it and return its 
//index. If it does not exist, return -1. 
//
// 
// Example 1: 
// Input: s = "leetcode"
//Output: 0
// Example 2: 
// Input: s = "loveleetcode"
//Output: 2
// Example 3: 
// Input: s = "aabb"
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of only lowercase English letters. 
// 
// Related Topics Hash Table String Queue Counting 
// 👍 4060 👎 174


package leetcode.editor.en;

import tool.Tool;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        Tool.print(solution.firstUniqChar("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.isEmpty()) {
                return -1;
            }
            char[] chars = s.toCharArray();
            LinkedHashMap<Character, Integer> map = new LinkedHashMap();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (map.containsKey(c)) {
                    map.put(c, -1);
                } else {
                    map.put(c, i);
                }
            }
            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Character, Integer> entry = it.next();
                if (entry.getValue() != -1) {
                    return entry.getValue();
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
