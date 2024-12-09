/* 22. Generate Parentheses
Medium
Topics
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"] */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ThirtyThree {
    public static void main(String[] args) {
        GenerateParentheses paren = new GenerateParentheses();

        paren.generateParenthesis(3);
        paren.generateParenthesis2(3);
        paren.revise(3);
    }
}

class GenerateParentheses {

    public List<String> generateParenthesis2(int n) {
        List<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        backTrack2(out, stack, 0, 0, n);

        System.out.println(out);
        return out;
    }

    private void backTrack2(List<String> out, Stack<String> stack, int open, int close, int n) {
        if (open == n && close == n) {
            String pair = "";
            Iterator<String> val = stack.iterator();
            while (val.hasNext()) {
                pair += val.next();
            }
            out.add(pair);
        }

        if (open < n) {
            stack.push("(");
            backTrack2(out, stack, open + 1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.push(")");
            backTrack2(out, stack, open, close + 1, n);
            stack.pop();
        }

    }

    public List<String> generateParenthesis(
            int n) {
        List<String> out = new ArrayList<>();

        backTrack(out, "", 0, 0, n);

        System.out.println(out);
        return out;
    }

    private void backTrack(List<String> out, String pair, int open, int close, int n) {
        if (pair.length() == n * 2) {
            out.add(pair);
            return;
        }

        if (open < n) {
            String npair = pair + "(";
            backTrack(out, npair, open + 1, close, n);
            // if it was stack pop first
            // dont override string as pair += "(", as it will have "(" in the
            // left recursion tree also which is unwanted
            // then you should remove last character in string if you override with +=
            // make a new string by giving , pair + "(" , on argument
            // but if it was stack, we would have to pop the top element.
            /*
             * stack pop, overriding or concat string then remove last char, simply pass
             * `pair + "()"` on argument
             */
        }

        if (close < open) {
            backTrack(out, pair + ")", open, close + 1, n);
        }

    }

    public List<String> revise(int n) {
        List<String> out = new ArrayList<>();

        revisebackTrack(out, "", 0, 0, n);

        System.out.println(out);
        return out;
    }

    public void revisebackTrack(List<String> out, String str, int open, int close, int max) {

        if (open == max && close == max) {
            out.add(str);
            return;
        }

        if (open < max) {
            revisebackTrack(out, str + "(", open + 1, close, max);
        }

        if (close < open) {
            revisebackTrack(out, str + ")", open, close + 1, max);
        }
    }
}