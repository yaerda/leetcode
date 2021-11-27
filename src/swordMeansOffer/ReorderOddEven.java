package swordMeansOffer;

import tool.Tool;

public class ReorderOddEven {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Tool.print(nums);
        ReorderOddEven instance = new ReorderOddEven();
        instance.solution(nums, instance::oddBefore, instance::evenAfter);
        Tool.print(nums);
    }

    public void solution(int[] nums, IsBefore isBefore, IsAfter isAfter) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, len = nums.length, j = len - 1;
        while (i < j) {
            while (i < j && isAfter.isAfter(nums, j)) {
                j--;
            }
            while (i < j && isBefore.isBefore(nums, i)) {
                i++;
            }
            Tool.swap(nums, i, j);
        }
    }

    private boolean oddBefore(int[] nums, int i) {
        return (nums[i] & 1) == 1;
    }

    private boolean evenAfter(int[] nums, int i) {
        return (nums[i] & 1) == 0;
    }
}
