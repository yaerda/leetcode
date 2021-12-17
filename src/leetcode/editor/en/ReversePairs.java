//Given an integer array nums, return the number of reverse pairs in the array. 
//
//
// A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 
//2 * nums[j]. 
//
// 
// Example 1: 
// Input: nums = [1,3,2,3,1]
//Output: 2
// Example 2: 
// Input: nums = [2,4,3,5,1]
//Output: 3
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree Seg
//ment Tree Merge Sort Ordered Set 
// 👍 2201 👎 167


package leetcode.editor.en;

import tool.Tool;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class ReversePairs {

    public static void main(String[] args) throws IOException, URISyntaxException {

//        File file = new File("D:\\code\\leetcode\\out\\production\\leetcode\\list2.txt");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        String str = bufferedReader.readLine();
//        List<Integer> list = new ArrayList<>();
//        int i = 0, j = 0, len2 = str.length();
//        while (i < len2) {
//            while (i <= len2 - 1 && str.charAt(i) != ',') {
//                i++;
//            }
//            list.add(Integer.valueOf(str.substring(j, i)));
//            i++;
//            j = i;
//        }
//
//        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
//        int[] nums2 = list.stream().mapToInt(Integer::intValue).toArray();
//        int[] nums3 = list.stream().mapToInt(Integer::intValue).toArray();
        int[] nums = {1, 3, 2, 3, 1};
        int[] nums2 = {1, 3, 2, 3, 1};
        int[] nums3 = {1, 3, 2, 3, 1};

        Solution4 solution = new ReversePairs().new Solution4();
        Solution solution2 = new ReversePairs().new Solution();
        Solution3 solution3 = new ReversePairs().new Solution3();

        int len = nums.length;

        Tool.print(nums.length);
        Tool.print("start solution 1:");

        long cur = System.currentTimeMillis();
        Tool.print(solution.reversePairs(nums));
        long end1 = System.currentTimeMillis();

        Tool.print("solution 1 use:" + (end1 - cur));

        Tool.print("start solution 2:");
        long cur2 = System.currentTimeMillis();
        Tool.print(solution2.reversePairs(nums2));
        long end2 = System.currentTimeMillis();
        Tool.print("solution 2 use:" + (end2 - cur2));


        Tool.print("start solution 3:");
        long cur3 = System.currentTimeMillis();
        Tool.print(solution3.reversePairs(nums3));
        long end3 = System.currentTimeMillis();
        Tool.print("solution3  use:" + (end3 - cur3));

    }

    class Solution4 {
        public int reversePairs(int[] nums) {
            Set<Long> allNumbers = new TreeSet<Long>();
            for (int x : nums) {
                allNumbers.add((long) x);
                allNumbers.add((long) x * 2);
            }
            // 利用哈希表进行离散化
            Map<Long, Integer> values = new HashMap<Long, Integer>();
            int idx = 0;
            for (long x : allNumbers) {
                values.put(x, idx);
                idx++;
            }

            int ret = 0;
            BIT bit = new BIT(values.size());
            for (int i = 0; i < nums.length; i++) {
                int left = values.get((long) nums[i] * 2), right = values.size() - 1;
                ret += bit.query(right + 1) - bit.query(left + 1);
                bit.update(values.get((long) nums[i]) + 1, 1);
            }
            return ret;
        }
    }

    class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x, int d) {
            while (x <= n) {
                tree[x] += d;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x != 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }

    class Solution3 {
        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            return reversePairsRecursive(nums, 0, nums.length - 1);
        }

        public int reversePairsRecursive(int[] nums, int left, int right) {
            if (left == right) {
                return 0;
            } else {
                int mid = (left + right) / 2;
                int n1 = reversePairsRecursive(nums, left, mid);
                int n2 = reversePairsRecursive(nums, mid + 1, right);
                int ret = n1 + n2;

                // 首先统计下标对的数量
                int i = left;
                int j = mid + 1;
                while (i <= mid) {
                    while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                        j++;
                    }
                    ret += j - mid - 1;
                    i++;
                }

                // 随后合并两个排序数组
                int[] sorted = new int[right - left + 1];
                int p1 = left, p2 = mid + 1;
                int p = 0;
                while (p1 <= mid || p2 <= right) {
                    if (p1 > mid) {
                        sorted[p++] = nums[p2++];
                    } else if (p2 > right) {
                        sorted[p++] = nums[p1++];
                    } else {
                        if (nums[p1] < nums[p2]) {
                            sorted[p++] = nums[p1++];
                        } else {
                            sorted[p++] = nums[p2++];
                        }
                    }
                }
                for (int k = 0; k < sorted.length; k++) {
                    nums[left + k] = sorted[k];
                }
                return ret;
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] tmp, nums;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSorts(0, nums.length - 1);
        }

        private int mergeSorts(int start, int end) {
            if (start >= end) {
                return 0;
            }
            int mid = start + ((end - start) >> 1);
            int res = mergeSorts(start, mid) + mergeSorts(mid + 1, end);
            for (int i = start; i <= end; i++) {
                tmp[i] = nums[i];
            }
            int i = start, j = mid + 1, i2 = i, j2 = j;
            while (i2 <= mid) {
                while (j2 <= end && (long) nums[i2] > 2L * nums[j2]) {
                    j2++;
                }
                res += j2 - mid - 1;
                i2++;
            }
            for (int k = start; k <= end; k++) {
                if (i == mid + 1) {
                    nums[k] = tmp[j++];
                } else if (j == end + 1 || tmp[i] < tmp[j]) {
                    nums[k] = tmp[i++];
                } else {
                    nums[k] = tmp[j++];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
