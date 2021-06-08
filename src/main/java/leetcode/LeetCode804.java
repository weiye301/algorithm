package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weiye
 * @date 2021/6/1 11:31
 */
public class LeetCode804 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            Set<String> result = new HashSet<>();
            for (String word : words) {
                StringBuilder res = new StringBuilder();
                for (char c : word.toCharArray()) {
                    res.append(codes[c - 'a']);
                }
                result.add(res.toString());
            }
            return result.size();
        }
    }
}
