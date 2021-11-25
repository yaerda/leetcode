package baseAlgorithm.sort;

import tool.Tool;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {23, 10, 28, 38, 29, 38, 29, 33, 30, 29};
        new CountingSort().sort(nums, 45);
    }

    public void sort(int[] nums, int max) {
        Tool.print(nums);
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int j = 0;
        for (int i = 1; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                nums[j++] = i;
                bucket[i]--;
            }
        }
        Tool.print(nums);
    }
}
