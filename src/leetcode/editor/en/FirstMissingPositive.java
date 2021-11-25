//Given an unsorted integer array, find the smallest missing positive integer. 
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Follow up: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array 
// 👍 3902 👎 832


package leetcode.editor.en;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[][] numss = new int[][]{{1}, {1, 1}, {1, 2, 0}, {3, 4, -1, 1}, {7, 8, 9, 11, 12}};
        for (int i = 0; i < numss.length; i++) {
            int[] nums = numss[i];
            System.out.print(IntStream.of(nums).boxed().map(String::valueOf).collect(Collectors.joining(",")));
            System.out.println("  result:" + solution.firstMissingPositive(nums));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) return 1;
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                if (temp <= 0 || temp > nums.length) {
                    nums[i] = 0;
                    continue;
                }
                while (temp != i + 1 && temp > 0 && nums[i] != nums[temp - 1]) {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    temp = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}