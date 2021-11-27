package swordMeansOffer;

public class PrintFrom1ToTheLargestN {
    public static void main(String[] args) {
        new PrintFrom1ToTheLargestN().solution(5);
    }
    public void solution(int n) {
        if (n < 1) {
            throw new RuntimeException("N must be greater than 0");
        }
        char[] nums;
        for (int i = 1; i <= n; i++) {
            nums = new char[i];
            nums[0] = '1';
            for (int j = 1; j < i; j++) {
                nums[j] = '0';
            }
            int pos = i - 1;
            while (pos != -1) {
                pos = i - 1;
                System.out.print(nums);
                System.out.print(",");
                pos = add(nums, pos); //规则相同的步骤，考虑递归
            }
        }
    }

    private int add(char[] nums, int pos) {
        if (nums[pos] == '9') {
            if (pos == 0) {
                return -1;
            } else {
                nums[pos--] = '0';
                return add(nums, pos);
            }
        } else {
            nums[pos] += 1;
            return pos;
        }

    }
}