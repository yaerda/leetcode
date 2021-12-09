//Given two integer arrays pushed and popped each with distinct values, return t
//rue if this could have been the result of a sequence of push and pop operations 
//on an initially empty stack, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4),
//pop() -> 4,
//push(5),
//pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// Example 2: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// All the elements of pushed are unique. 
// popped.length == pushed.length 
// popped is a permutation of pushed. 
// 
// Related Topics Array Stack Simulation 
// 👍 2189 👎 40


package leetcode.editor.en;

import tool.Tool;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 4, 3, 5, 1};
        Solution solution = new ValidateStackSequences().new Solution();
        Tool.print(solution.validateStackSequences(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int j = 0;
            for (int x : pushed) {
                stack.push(x);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public boolean validateStackSequences2(int[] pushed, int[] popped) {
            int i = 0, j = 0;
            for (int x : pushed) {
                pushed[i++] = x;
                while (i > 0 && pushed[i - 1] == popped[j]) {
                    i--;
                    j++;
                }
            }
            return i == 0;
        }
    }

}
