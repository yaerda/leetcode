package sort;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        sort(nums);
    }

    public static void sort(int[] nums) {
        printArray(nums);
        sort(nums, 0, nums.length - 1);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.print("]");
    }

    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = partion(nums, lo, hi);
        sort(nums, lo, j);
        sort(nums, j + 1, hi);
    }

//    private static int duplePartion(int[] nums, int lo, int hi) {
//
//    }

    private static int partion(int[] nums, int lo, int hi) {
        int v = nums[lo], a = lo, b = hi + 1;
        while (true) {
            while (nums[++a] < v) {
                if (a == hi) break;
            }
            while (nums[--b] >= v) {
                if (b == lo) break;
            }
            if (a >= b) {
                break;
            }
            change(nums, a, b);
        }
        change(nums, lo, b);
        return b;
    }

    private static void change(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
