package stack;

import java.util.Stack;

/**
 * @author weiye
 * @date 2021/2/2 11:35
 * 力扣155： 最小栈
 */
public class MinStack {

    private Stack<Integer> stack;
    private int minValue;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == minValue) {
            minValue = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}
