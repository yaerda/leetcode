package baseAlgorithm.sort;

import tool.Tool;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Tool.print(nums);
        sort(nums, 0, nums.length - 1);
        Tool.print(nums);

    }

    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = partion(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partion(int[] nums, int lo, int hi) {
        int p = nums[lo], i = lo, j = hi; //如果 i 从lo+1 开始，在左大右小的情况下无法进入循环，也无法更新i，j到j，也就无法swap到正常顺序
        while (i < j) {
            while (nums[j] >= p && i < j) { // 等于号可以让从lo开始的数在左大右小的情况下正常交换
                j--;
            }
            while (nums[i] <= p && i < j) {
                i++;
            }
            Tool.swap(nums, i, j);
        }
        Tool.swap(nums, lo, i);
        return i;
    }

    private static int partion2(int[] nums, int lo, int hi) {

        int p = nums[lo], index = lo + 1;
        for (int i = index; i <= hi; i++) {
            if (nums[i] < p) {
                Tool.swap(nums, i, index++);
            }
        }
        Tool.swap(nums, lo, index - 1); // index -1 因为index++已超出到大于p的地方，所以-1后才可以做中间pivot
        return index - 1;
    }


}
