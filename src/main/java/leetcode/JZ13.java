package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weiye
 * @date 2021/4/29 10:45
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class JZ13 {
    class Solution {

        public int movingCount(int m, int n, int k) {
            //记录结果
            int res = 0;
            //标记某个位置是否查找过
            boolean[][] tmp = new boolean[m][n];
            //用来遍历的队列
            Queue<int[]> queue= new LinkedList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] curIndex = queue.poll();
                int i = curIndex[0];
                int j = curIndex[1];
                //如果i，j越界 或 数位和大于k 或 查找过此位置 跳出
                if (i >= m || j >= n || sum(i, j) > k || tmp[i][j]) {
                    continue;
                }
                //到这里说明符合条件且没访问过
                tmp[i][j] = true;
                res++;
                //向右找
                queue.add(new int[]{i + 1, j});
                //向下找
                queue.add(new int[]{i, j + 1});
            }
            return res;
        }


        /**
         * 计算两个坐标的数位和
         *
         * @param i i
         * @param j j
         * @return 和
         */
        private int sum(int i, int j) {
            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            return sum;
        }
    }
}


