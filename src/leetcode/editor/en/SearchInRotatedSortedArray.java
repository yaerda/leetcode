//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search


package leetcode.editor.en;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(array, 4));
        int[] array2 = {3, 1};
        System.out.println(solution.search2(array2, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int m = lo + (hi - lo) / 2;
                if (nums[m] == target) return m;
                //split point in left
                if (nums[m] < nums[hi]) {
                    if (nums[m] < target && nums[hi] >= target) {
                        lo = m + 1;
                    } else {
                        hi = m - 1;
                    }
                } else {
                    if (nums[lo] <= target && nums[m] > target) {
                        hi = m - 1;
                    } else {
                        lo = m + 1;
                    }
                }
            }
            return -1;
        }

        public int search2(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] >= nums[left]) {  //考虑长度为2的数组时，mid = left = 0的情况
                    if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                    else left = mid + 1;
                } else {
                    if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                    else right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
