package swordMeansOffer;

import tool.Tool;

import javax.management.AttributeList;
import java.util.Collection;
import java.util.HashMap;

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber number = new UglyNumber();
        Tool.print(number.solution(1));
        Tool.print(number.solution(2));

        Tool.print(number.solution(3));

        Tool.print(number.solution(4));

        Tool.print(number.solution(5));

        Tool.print(number.solution(6));

        Tool.print(number.solution(7));

        Tool.print(number.solution(8));
        Tool.print(number.solution(9));
        Tool.print(number.solution(10));
        Tool.print(number.solution(11));
        Tool.print(number.solution(1500));
        Tool.print(number.solution(0));


    }

    public int solution(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int index = 1, start2 = 0, start3 = 0, start5 = 0;
        while (index < n) {
            int min = min3(nums[start2] * 2, nums[start3] * 3, nums[start5] * 5);
            nums[index] = min;
            while (nums[start2] * 2 <= nums[index]) {
                start2++;
            }
            while (nums[start3] * 3 <= nums[index]) {
                start3++;
            }
            while (nums[start5] * 5 <= nums[index]) {
                start5++;
            }
            index++;
        }
        return nums[n - 1];

    }

    private int min3(int n1, int n2, int n3) {
        if (n1 < n2) {
            return Math.min(n1, n3);
        } else {
            return Math.min(n2, n3);
        }
    }

}
