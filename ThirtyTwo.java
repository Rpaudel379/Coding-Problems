// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
// Evaluate the expression. Return an integer that represents the value of the expression.

import java.util.Stack;

public class ThirtyTwo {
    public static void main(String[] args) {
        RPN rpn = new RPN();

        // String[] tokens = { "2", "1", "+", "3", "*" };
        // String[] tokens = { "4", "13", "5", "/", "+" };

        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17",
                "+", "5", "+" };

        rpn.evalRPN(tokens);
        rpn.evalRPN2(tokens);
    }
}

class RPN {

    public int evalRPN2(String[] tokens) {

        Stack<String> stack = new Stack<>();

        String dig = "-1";

        for (String s : tokens) {

            if (s.equals("+")) {
                dig = Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()));
            } else if (s.equals("-")) {
                int y = Integer.parseInt(stack.pop());
                dig = Integer.toString(Integer.parseInt(stack.pop()) - y);
            } else if (s.equals("*")) {
                dig = Integer.toString(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()));
            } else if (s.equals("/")) {
                int y = Integer.parseInt(stack.pop());
                dig = Integer.toString(Integer.parseInt(stack.pop()) / y);
            } else {
                dig = s;
            }

            stack.push(dig);
        }

        System.out.println(stack);
        return Integer.parseInt(dig);
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                int eval = x +  y;

                stack.push(eval);
            } else if (s.equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                int eval = y - x;

                stack.push(eval);
            } else if (s.equals("*")) {
                int x = stack.pop();
                int y = stack.pop();
                int eval = y * x;

                stack.push(eval);
            } else if (s.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                int eval = y / x;

                stack.push(eval);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        System.out.println(stack);

        return stack.peek();
    }

}