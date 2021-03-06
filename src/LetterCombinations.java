import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(combination3("234"));
        System.out.println(combination2("234"));
        System.out.println(combination("234"));
    }

    private static final Map<Character, List<String>> DIGIT_MAP = new HashMap<Character, List<String>>() {
        /**
        *
        */
        private static final long serialVersionUID = 1L;
        {   
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    private static List<String> combination3(String digits) {
        String[] digtiMap = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        LinkedList<String> str = new LinkedList<String>();
        if (digits.isEmpty())
                return str;
        str.add("");
        for (char c : digits.toCharArray()) {
                String digitStr = digtiMap[c - '2'];
                int size = str.size();
                for (int i = 0; i < size; i++) {
                        String s = str.remove();
                        for (char tempC : digitStr.toCharArray()) {
                                str.add(s + tempC);
                        }
                }
        }
        return str;

}

    private static List<String> combination2(String digits) {
        LinkedList<String> stringList = new LinkedList<>();
        if (digits.isEmpty()) return stringList;

        stringList.add("");
        while (stringList.peek().length() != digits.length()) {
            String s = stringList.remove();
            List<String> digitStringList = DIGIT_MAP.get(digits.charAt(s.length()));
            for (String c : digitStringList) {
                stringList.add(s + c);
            }
        }
        return stringList;
    }

    private static List<String> combination(String digits) {
        List<String> str = new ArrayList<>();
        if (digits.isEmpty()) return str;

        str.add("");
        for (char c : digits.toCharArray()) {
            List<String> digString = DIGIT_MAP.get(c);
            List<String> temp = new ArrayList<>();
            for (String s : digString) {
                for (String s1 : str) {
                    temp.add(s1 + s);
                }
            }
            str = temp;
        }

        return str;
    }
}
