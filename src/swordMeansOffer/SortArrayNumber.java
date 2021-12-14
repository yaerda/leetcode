package swordMeansOffer;

import tool.Tool;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SortArrayNumber {
    public static void main(String[] args) {
        new SortArrayNumber().solution(new int[]{132, 23, 546, 111});
    }

    public void solution(int[] array) {
        TreeSet<String> sortNums = new TreeSet<>(String::compareTo);
        for (int num : array) {
            sortNums.add(String.valueOf(num));
        }
        StringBuilder builder = new StringBuilder();
        Iterator it = sortNums.iterator();
        while (it.hasNext()) {
            builder.append(it.next());
        }
        Tool.print(builder.toString());
    }
}
