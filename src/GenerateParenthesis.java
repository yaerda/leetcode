import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(gen(3));

    }

    public static List<String> gen(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}