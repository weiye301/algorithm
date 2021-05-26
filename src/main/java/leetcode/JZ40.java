package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author weiye
 * @date 2021/5/20 14:37
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class JZ40 {
    class Solution {
        private Random random = new Random();

        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) return new int[0];
            int index = selectK(arr, 0, arr.length - 1, k - 1);
            return Arrays.copyOf(arr, k);
        }

        private int selectK(int[] arr, int left, int right, int k) {
            int index = partition(arr, left, right);
            if (index == k) return arr[index];
            if (index > k) return selectK(arr, left, index - 1, k);
            return selectK(arr, index + 1, right, k);
        }

        private int partition(int[] arr, int left, int right) {
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(arr, left, randomIndex);
            int i = left + 1;
            int j = right;
            while (true) {
                while (i <= j && arr[i] < arr[left]) i++;
                while (j >= i && arr[j] > arr[left]) j--;
                if (i >= j) break;
                swap(arr, i, j);
                i++;
                j--;
            }
            swap(arr, left, j);
            return j;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
