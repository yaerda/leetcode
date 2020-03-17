/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.46%)
 * Total Accepted:    607.1K
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 * Example 2:
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 */
class MedianOfTwoSorteArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        try {
            System.out.println(findMedianSortedArrays(nums1, nums2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //keep nums1 < nums2
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        int imin = 0;
        int imax = m;
        int i;
        int j;
        int maxOfLeft = 0;
        int minOfRight = 0;
        boolean finded = false;
        while (!finded) {
            //keep left ~ right
            i = (imin + imax) / 2;
            j = (m + n + 1) / 2 - i;

            //adjust i position
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                --imax;
            } else if (i < m && nums1[i] < nums2[j - 1]) {
                ++imin;
            } else {
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }
                finded = true;
            }
        }
        return (maxOfLeft + minOfRight) / 2.0;
    }

}
