package swordMeansOffer;

import tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        Tool.print(new StringPermutation().solution("123"));
    }

    public List solution(String string) {
        if (string == null) {
            return new ArrayList();
        }
        return permutaion(string);
    }

    private List<String> permutaion(String string) {
        List<String> list = new ArrayList<>();
        if (string == null || string.isEmpty()) {
            return list;
        }
        if (string.length() == 1) {
            list.add(string);
            return list;
        }
        char[] characters = string.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            switchChar(characters, 0, i);
            String otherStr = new String(characters, 1, characters.length - 1);
            List<String> otherList = permutaion(otherStr);
            for (String s : otherList) {
                list.add(characters[0] + s);
            }
            switchChar(characters, i, 0);

        }
        return list;
    }

    private void switchChar(char[] characters, int i, int j) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }
}
