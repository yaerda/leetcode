//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4] 
// 
//
// Note: 
//
// 
// Each element in the result must be unique. 
// The result can be in any order. 
// 
//
// 
// Related Topics Hash Table Two Pointers Binary Search Sort


package leetcode.editor.en;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        for (int i : solution.intersection2(nums1, nums2)) {
            System.out.println(i);
        }

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[0];
            }
            List<Integer> result = new ArrayList<>();
            int i = 0, j = 0;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    if (result.isEmpty() || result.get(result.size() - 1) != nums1[i])
                        result.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) i++;
                else j++;
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[0];
            }
            HashSet<Integer> result = new HashSet<>();
            Arrays.sort(nums1);
            for (int num : nums2) {
                if (binarySearch(nums1, num) > -1) {
                    result.add(num);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private int binarySearch(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
