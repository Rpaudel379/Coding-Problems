import java.util.HashMap;
import java.util.Stack;

public class Twenty {
    public static void main(String[] args) {
        ValidParen vp = new ValidParen();

        // String s = "()";
        String s = "()[]{}";
        // String s = "(]";
        // String s = "(){}}{";

        System.out.println(vp.isValid(s));
        System.out.println(vp.isValid2(s));
        System.out.println(vp.isValid3(s));
        System.out.println(vp.revise(s));
    }
}

class ValidParen {

    public boolean isValid3(String s) {

        char[] stack = new char[s.length()];
        int i = -1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++i] = ')';
            } else if (c == '{') {
                stack[++i] = '}';
            } else if (c == '[') {
                stack[++i] = ']';
            } else {
                if (i == -1 || (c != stack[i--])) {
                    return false;
                }
            }
        }

        return i == -1;
    }

    public boolean isValid2(String s) {

        char[] stack = new char[s.length()];
        int i = -1;

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack[++i] = c;
            } else {
                if (i >= 0 && (stack[i] == '(' && c == ')' || stack[i] == '{' && c == '}'
                        || stack[i] == '[' && c == ']')) {
                    i--;
                } else {
                    return false;
                }
            }

        }

        return i == -1;
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        int length = s.length();

        if (length == 1) {
            return false;
        }

        HashMap<Character, Character> matching = new HashMap<>();
        matching.put(')', '(');
        matching.put('}', '{');
        matching.put(']', '[');

        for (char c : s.toCharArray()) {

            if (matching.containsKey(c)) {

                if (!stack.empty() && stack.peek() == matching.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(c);
            }

        }

        return stack.empty() ? true : false;
    }

    public boolean revise(String s) {

        char[] stack = new char[s.length()];

        int i = -1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++i] = ')';
            } else if (c == '{') {
                stack[++i] = '}';
            } else if (c == '[') {
                stack[++i] = ']';
            } else {
                if (i > -1 && (stack[i] == c)) {
                    i--;
                } else {
                    return false;
                }
            }
        }

        return i == -1;
    }

}