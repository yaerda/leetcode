package swordMeansOffer;

import tool.Tool;

public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        Tool.print(countDigitOne.solution(12));
        Tool.print(countDigitOne.solution(123));
        Tool.print(countDigitOne.solution(2312));
    }

    public int verify(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                int one = temp % 10;
                if (one == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }
        return count;
    }

    public int solution(int n) {
        int high = n / 10;      // 当前位数前面的数
        int low = 0;            // 当前位数后面的数
        int cur = n - high * 10;     //当前位数上的数字
        int digit = 1;          //当前位数
        int count = 0;          // 1出现的次数
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                count += high * digit;      //cur 为0，则高位只能小于1，加上低位到9，所以是高位*digit
            } else if (cur == 1) {
                count += high * digit + low + 1;        //cur为1，则高低位均为原数，所以是高低位的拼数
            } else {
                count += (high + 1) * digit;        //cur大于1，高位为原数，低位最多可以到9，所以是(高位+1)*digit
            }
            low = cur * digit + low;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        int v = verify(n);
        Tool.print((count == v) + "  " + v);
        return count;
    }
}
