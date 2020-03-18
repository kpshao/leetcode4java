package stack;

import java.util.Stack;

public class ReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int a, b;
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new ReversePolish().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(new ReversePolish().evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(new ReversePolish().evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }
}
