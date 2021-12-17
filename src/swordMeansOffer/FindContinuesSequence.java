package swordMeansOffer;

import tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class FindContinuesSequence {
    public static void main(String[] args) {
        FindContinuesSequence seq = new FindContinuesSequence();
        Tool.print(seq.sequences(6));
        Tool.print(seq.sequences(15));
        Tool.print(seq.sequences(8));
        Tool.print(seq.sequences(9));
        Tool.print(seq.sequences(10));

    }

    public List sequences(int target) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 1, end = 2, sum = start + end, maxStart = (target + 1) >> 1;
        while (start < maxStart && end < target) {
            if (sum == target) {
                List<Integer> seq = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    seq.add(i);
                }
                list.add(seq);
            }
            if (sum <= target) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        return list;
    }
}
