package swordMeansOffer;

import tool.Tool;

public class GetNumbersOfK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6, 6, 6, 8};
        Tool.print(new GetNumbersOfK().solution(nums, 6));
        Tool.print(new GetNumbersOfK().solution(nums, 3));
        Tool.print(new GetNumbersOfK().solution(nums, -1));
        Tool.print(new GetNumbersOfK().solution(nums, 9));

    }

    public int solution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int first = getFirst(nums, k);
        if (first == -1) {
            return -1;
        }
        int last = getLast(nums, k);
        return last - first + 1;
    }

    private int getFirst(int[] nums, int k) {
        int before = -1, temp, end = nums.length - 1;
        while (true) {
            temp = binarySearch(nums, k, 0, end);
            if (temp == -1) {
                return before;
            }
            before = temp;
            end = temp - 1;
        }
    }

    private int getLast(int[] nums, int k) {
        int last = -1, temp, start = 0;
        while (true) {
            temp = binarySearch(nums, k, start, nums.length - 1);
            if (temp == -1) {
                return last;
            }
            last = temp;
            start = temp + 1;
        }
    }

    private int binarySearch(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (nums[mid] == k) {
            return mid;
        } else if (nums[mid] < k) {
            return binarySearch(nums, k, mid + 1, end);
        } else {
            return binarySearch(nums, k, start, mid - 1);
        }
    }
}
