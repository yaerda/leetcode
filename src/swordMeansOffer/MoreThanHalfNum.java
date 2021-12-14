package swordMeansOffer;

import tool.Tool;

import java.net.PortUnreachableException;

public class MoreThanHalfNum {
    public static void main(String[] args) {

        int[] nums = {3, 3, 1, 2};
        Tool.print(new MoreThanHalfNum().searchK(nums, 0, nums.length - 1, nums.length / 2));
        Tool.print(new MoreThanHalfNum().countInArray(nums));
    }

    public int searchK(int[] nums, int start, int end, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int pivot = partition(nums, start, end);
        if (pivot < k) {
            return searchK(nums, pivot + 1, end, k);
        } else if (pivot > k) {
            return searchK(nums, start, pivot - 1, k);
        } else {
            return nums[pivot];
        }
    }


    public int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int par = start, i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= nums[par]) {
                j--;
            }
            while (i < j && nums[i] <= nums[par]) {
                i++;
            }
            Tool.swap(nums, i, j);
        }
        Tool.swap(nums, par, i);
        return i;
    }

    public int partition2(int[] nums, int start, int end) {
        int p = nums[start], index = start + 1;
        for (int i = index; i <= end; i++) {
            if (nums[i] <= p) {
                Tool.swap(nums, i, index++);
            }
        }
        Tool.swap(nums, start, index - 1);
        return index - 1;
    }

    public int countInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int m = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != m) {
                if (count == 0) {
                    m = nums[i];
                    count++;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        if (count >= nums.length / 2) {
            return m;
        }
        throw new IllegalArgumentException();
    }
}
