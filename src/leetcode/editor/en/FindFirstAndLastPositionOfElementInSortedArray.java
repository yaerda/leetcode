//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// nums is a non decreasing array. 
// -10^9 <= target <= 10^9 
// 
// Related Topics Array Binary Search 
// 👍 3858 👎 158


package leetcode.editor.en;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] tCase = new int[]{5, 7, 7, 8, 8, 10};
        int[] targets = new int[]{0, -1, 5, 8, 10, 12};
        for (int target : targets) {
            System.out.print("target: " + target + "\t");
            System.out.println(IntStream.of(solution.searchRange(tCase, target)).boxed().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int lo = 0;
            int hi = nums.length - 1;
            int mid = binarySearch(nums, lo, hi, target);
            if (mid == -1) return new int[]{-1, -1};
            int left = minBinarySearch(nums, lo, mid - 1, target);
            int right = maxBinarySearch(nums, mid + 1, hi, target);
            return new int[]{left, right};
        }

        private int binarySearch(int[] nums, int lo, int hi, int target) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                //not return now
                if (nums[mid] == target) return mid;
                //loc in left
                if (nums[lo] <= target && nums[mid] > target) hi = mid - 1;
                    //loc in right
                else if (nums[mid] < target && nums[hi] >= target) lo = mid + 1;
                else return -1;
            }
            return -1;
        }

        private int minBinarySearch(int[] nums, int lo, int hi, int target) {
            int min = hi + 1, tempMin = hi + 1;
            while (tempMin != -1) {
                min = tempMin;
                tempMin = binarySearch(nums, lo, hi, target);
                hi = tempMin - 1;
            }
            return min;
        }

        private int maxBinarySearch(int[] nums, int lo, int hi, int target) {
            int max = lo - 1, tempMax = lo - 1;
            while (tempMax != -1) {
                max = tempMax;
                tempMax = binarySearch(nums, lo, hi, target);
                lo = tempMax + 1;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}