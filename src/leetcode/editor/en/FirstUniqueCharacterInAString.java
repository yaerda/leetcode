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
            int[] arr = new int[26];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                arr[aChar - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (arr[chars[i] - 'a'] == 1) {
                    return i;
                }

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
