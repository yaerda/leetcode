//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 8696 👎 410


package leetcode.editor.en;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();

        System.out.println(fib(20));
        System.out.println(fibMemo(20));
        System.out.println(fibDp(20));

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArrayShort(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i];
                dp[i] = Math.max(cur, cur + dp[i - 1]);
            }
            int max = dp[0];
            for (int i = 1; i < dp.length; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public int maxSubArrayShort(int[] nums) {
            int prevMax = nums[0];
            int maxSum = prevMax;
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i];
                prevMax = Math.max(cur, cur + prevMax);
                maxSum = Math.max(prevMax, maxSum);
            }
            return maxSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    private static int fib(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    private static int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return memo(memo, n);
    }

    private static int memo(int[] memo, int n) {
        memo[1] = 1;
        memo[2] = 1;
        if (n == 1 || n == 2) {
            return memo[n];
        }
        if (memo[n - 1] == 0) {
            memo[n - 1] = fib(n - 1);
        }
        if (memo[n - 2] == 0) {
            memo[n - 2] = fib(n - 2);
        }

        return memo(memo, n - 1) + memo(memo, n - 2);
    }

    private static int fibDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}