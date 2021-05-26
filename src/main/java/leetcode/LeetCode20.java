package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weiye
 * @date 2021/5/11 10:49
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
public class LeetCode20 {
    class Solution {
        public boolean isValid(String s) {
            if (s.isEmpty()) return true;
            Deque<Character> stack = new LinkedList<>();
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

            if (stack.isEmpty()) {
                return true;
            }

            return false;

        }
    }
}
