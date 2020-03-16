package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> nums = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        nums.push(x);
        if (mins.isEmpty()) {
            mins.push(x);
        } else if (mins.peek() >= x) {
            mins.push(x);
        }

    }

    public void pop() {
        int x = nums.peek();
        nums.pop();

        if (mins.peek() == x) {
            mins.pop();
        }

    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
