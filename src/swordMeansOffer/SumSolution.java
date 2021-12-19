package swordMeansOffer;

import tool.Tool;

public class SumSolution {
    public static void main(String[] args) {

        Tool.print(new SumSolution().sum(5));
    }

    public int sum(int n) {
        boolean x = n > 1 && (n += sum(n - 1)) > 0;
        return n;
    }
}