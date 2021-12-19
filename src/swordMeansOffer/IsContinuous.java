package swordMeansOffer;

import tool.Tool;

import javax.print.DocFlavor;
import java.util.Arrays;

public class IsContinuous {
    public static void main(String[] args) {

        int[][] nums = new int[][]{{11, 0, 9, 0, 0}, {2, 2, 1, 3, 5}, {1, 3, 5, 0, 0}, {11, 2, 1, 9, 0}, {2, 4, 3, 1, 0}};
        IsContinuous is = new IsContinuous();
        for (int[] num : nums) {
            Tool.print(is.verify(num));
        }
    }

    public boolean verify(int[] nums) {
        Arrays.sort(nums);
        int zero=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                zero++;
            }else if(i>0 && nums[i]==nums[i-1]){
                return false;
            }
        }
        return nums[nums.length-1]-nums[zero]<5;
    }
}
