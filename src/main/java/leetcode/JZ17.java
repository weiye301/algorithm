package leetcode;

/**
 * @author weiye
 * @date 2021/5/6 10:59
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class JZ17 {
    class Solution {

        char[] num;
        int n;
        int[] result;
        int count = 0;

        public int[] printNumbers(int n) {
            this.n = n;
            num = new char[n];
            result = new int[(int) (Math.pow(10, n) - 1)];
            dfs(0);
            return result;
        }

        private void dfs(int x) {
            if (x == n) {
                String numberStr = String.valueOf(num);
                int number = Integer.parseInt(numberStr);
                if (number != 0) {
                    result[count++] = number;
                }
                return;
            }
            for (char i = '0'; i <= '9'; i++) {
                num[x] = i;
                dfs(x + 1);
            }
        }
    }
}
