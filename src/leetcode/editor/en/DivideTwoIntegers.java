//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Note: 
//
// 
// Both dividend and divisor will be 32-bit signed integers. 
// The divisor will never be 0. 
// Assume we are dealing with an environment which could only store integers wit
//hin the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pr
//oblem, assume that your function returns 231 − 1 when the division result overfl
//ows. 
// 
// Related Topics Math Binary Search


package leetcode.editor.en;

public class DivideTwoIntegers {
    public static void main(String[] args) {

        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-1010369383, -2147483648));
        System.out.println(-1010369383 / -2147483648);
        System.out.println(solution.divide(10, -3));
        System.out.println(10 / -3);
        System.out.println(solution.divide(-2147483648, 1));
        System.out.println(-2147483648 / 1);
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(-2147483648 / -1+" >> returns 2147483647 when overflow");
        System.out.println(solution.divide(-2147483648, -2147483648));
        System.out.println(-2147483648 / -2147483648);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                return Integer.MAX_VALUE;
            }
            int i = 0;
            boolean negative = (dividend < 0 ^ divisor < 0);
            int posDividend = Math.abs(dividend);  // less than 0 is Integer.MIN_VALUE;
            int posDivisor = Math.abs(divisor);    //also

            if (posDividend < 0 && posDivisor < 0) {
                return 1;
            } else if (posDivisor < 0) {
                return 0;
            } else if (posDividend < 0) {
                if (posDivisor == 1) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE; // with posDivisor is 1  forbid overflow in add process below
                } else {
                    posDividend = Integer.MAX_VALUE;
                    i = 1;
                    posDividend = posDividend - posDivisor + 1; //  use Integer.MAX_VALUE  less than abs(Integer.MIN_VALUE) 1,so make up it
                }
            }
            while (posDividend >= posDivisor) {
                int shift = 0;
                while ((posDivisor << (shift + 1) > 0) && posDivisor << (shift + 1) <= posDividend) {
                    shift++;
                }
                posDividend -= posDivisor << shift;
                i += 1 << shift;
            }
            return negative ? -i : i;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
