package stack;

import java.util.Stack;

/**
 * @author weiye
 * @date 2021/2/1 12:21
 */
public class StackTest {
    public static void main(String[] args) {
//        Stack<Integer> stack = new ArrayStack<>();
//        stack.push(1);
//        System.out.println(stack);
//        stack.push(2);
//        System.out.println(stack);
//        stack.push(3);
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);

    }

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
