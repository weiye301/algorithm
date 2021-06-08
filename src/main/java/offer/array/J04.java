package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 11:17
 */
public class J04 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;

            int row = matrix.length - 1;
            int column = 0;
            while (row >= 0 && column < matrix[0].length) {
                if (matrix[row][column] == target) {
                    return true;
                }
                if (matrix[row][column] > target) {
                    row--;
                } else {
                    column++;
                }
            }
            return false;
        }
    }
}
