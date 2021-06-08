package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 11:22
 */
public class J05 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == ' ') {
                    res.append("%20");
                } else {
                    res.append(cur);
                }
            }
            return res.toString();
        }
    }
}
