//You have n dice and each die has k faces numbered from 1 to k. 
//
// Given three integers n, k, and target, return the number of possible ways (ou
//t of the kn total ways) to roll the dice so the sum of the face-up numbers equal
//s target. Since the answer may be too large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1, k = 6, target = 3
//Output: 1
//Explanation: You throw one die with 6 faces.
//There is only one way to get a sum of 3.
// 
//
// Example 2: 
//
// 
//Input: n = 2, k = 6, target = 7
//Output: 6
//Explanation: You throw two dice, each with 6 faces.
//There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
// 
//
// Example 3: 
//
// 
//Input: n = 30, k = 30, target = 500
//Output: 222616187
//Explanation: The answer must be returned modulo 109 + 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
// Related Topics Dynamic Programming 
// 👍 1728 👎 75


package leetcode.editor.en;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new NumberOfDiceRollsWithTargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRollsToTarget(int n, int k, int target) {
            if (n * k < target) {
                return 0;
            }
            int mod = (int) Math.pow(10, 9) + 7;
            int[][] dp = new int[2][n * k + 1];
            int flag = 0;
            for (int i = 1; i <= k; i++) {
                dp[flag][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i * k && j <= target; j++) {
                    dp[1 - flag][j] = 0;
                    for (int l = 1; l <= k && l < j; l++) {
                        dp[1 - flag][j] = (dp[1 - flag][j] + dp[flag][j - l]) % mod;
                    }
                }
                flag = 1 - flag;
            }
            return dp[flag][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
