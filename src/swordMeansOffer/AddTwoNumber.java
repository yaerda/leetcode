package swordMeansOffer;

import tool.Tool;

public class AddTwoNumber {
    public static void main(String[] args) {
        Tool.print(new AddTwoNumber().solution(10, 29));
        Tool.print(new AddTwoNumber().solution(0, 29));
        Tool.print(new AddTwoNumber().solution(-10, 29));

    }

    public int solution(int x, int y) {
        int sum = 0, carry = 0;
        do {
            sum = x ^ y;
            carry = (x & y) << 1;
            x = sum;
            y = carry;
        } while (carry != 0);
        return sum;
    }
}
