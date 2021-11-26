package baseAlgorithm.select;

import baseAlgorithm.sort.QuickSort;
import tool.Tool;

public class QuickSelect {
    public static void main(String[] args) {
        int[] nums = {1, 2, 89, 23, 19, 28, 87, 12, 38, 29};
        System.out.println(new QuickSelect().quickSelect(nums, 0, nums.length - 1, 1));
        QuickSort.sort(nums, 0, nums.length - 1);
        Tool.print(nums);
    }

    /**
     * @param nums: int array
     * @param k:    kth biggest [lo,hi]
     * @return the num
     */
    private int quickSelect(int[] nums, int lo, int hi, int k) {
        if (k < 1 || k > nums.length) {
            throw new RuntimeException("The k [" + k + "] is out of range");
        }
        int pivot = partion(nums, lo, hi);
        if (nums.length - k == pivot) {
            return nums[pivot];
        } else if (nums.length - k > pivot) {
            return quickSelect(nums, pivot + 1, hi, k);
        } else {
            return quickSelect(nums, lo, pivot - 1, k);
        }
    }

    private int partion(int[] nums, int lo, int hi) {
        int p = nums[lo], index = lo + 1;
        for (int i = index; i <= hi; i++) {
            if (nums[i] < p) {
                Tool.swap(nums, i, index++);
            }
        }
        Tool.swap(nums, lo, index - 1);
        return index - 1;
    }


}