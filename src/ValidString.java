import java.util.Stack;

class ValidString {
    public static void main(String[] args) {
        String[] strs = { "()", "[]", "({)}", "([])", "]" };
        for (String s : strs) {
            System.out.println(s + " isValid: " + isValid(s));
            System.out.println(s + " isValid: " + isValid2(s));
        }
    }

    private static boolean isValid2(String s) {
        Stack<Character> cStack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    cStack.push(')');
                    break;
                case '{':
                    cStack.push('}');
                    break;
                case '[':
                    cStack.push(']');
                    break;
                default:
                    if (cStack.isEmpty() || cStack.pop() != c) {
                        return false;
                    }
            }
        }
        return cStack.isEmpty();
    }

    private static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> cStack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    cStack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (cStack.isEmpty()) {
                        return false;
                    }
                    char rc = cStack.pop();
                    if ((c == ')' && rc != '(') || (c == '}' && rc != '{') || (c == ']' && rc != '['))
                        return false;
                    break;
                default:
                    break;
            }
        }

        return cStack.isEmpty();
    }

}