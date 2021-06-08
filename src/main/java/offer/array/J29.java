package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 14:28
 */
public class J29 {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            int left = 0;
            int right = matrix[0].length - 1;
            int top = 0;
            int bottom = matrix.length - 1;
            int[] res = new int[(right + 1) * (bottom + 1)];
            int curIndex = 0;
            int lastNum = (right + 1) * (bottom + 1);
            while (lastNum > 0) {
                for (int i = left; i <= right && lastNum > 0; i++) {
                    res[curIndex++] = matrix[top][i];
                    lastNum--;
                }
                top++;

                for (int i = top; i <= bottom && lastNum > 0; i++) {
                    res[curIndex++] = matrix[i][right];
                    lastNum--;
                }
                right--;

                for (int i = right; i >= left && lastNum > 0; i--) {
                    res[curIndex++] = matrix[bottom][i];
                    lastNum--;
                }
                bottom--;

                for (int i = bottom; i >= top && lastNum > 0; i--) {
                    res[curIndex++] = matrix[i][left];
                    lastNum--;
                }
                left++;
            }
            return res;
        }
    }

}
