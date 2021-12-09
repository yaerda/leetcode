package swordMeansOffer;

import tool.Tool;

public class VerifyPostOrder {
    public static void main(String[] args) {
        int[][] nums = {{}, {5, 7, 6, 9, 11, 10, 8}, {8, 6, 10, 5, 7, 9, 11}};
        VerifyPostOrder verifyPostOrder = new VerifyPostOrder();
        for (int[] num : nums) {
            Tool.print(verifyPostOrder.solution(num));
        }
    }

    public boolean solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return verifyPostOrder(nums, 0, nums.length - 1);
    }

    private boolean verifyPostOrder(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rs = searchRightStart(nums, start, end);
        int root = nums[end];
        for (int i = start; i < rs; i++) {
            if (nums[i] > root) {
                return false;
            }
        }
        for (int i = rs; i < end; i++) {
            if (nums[i] < root) {
                return false;
            }
        }

        return verifyPostOrder(nums, start, rs - 1) && verifyPostOrder(nums, rs, end-1);
    }

    private int searchRightStart(int[] nums, int start, int end) {
        int root = nums[end];
        int i = start;
        while (i <= end && nums[i] < root) {
            i++;
        }
        return i;
    }
}
