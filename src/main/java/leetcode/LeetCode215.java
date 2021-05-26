package leetcode;

import java.util.Random;

/**
 * @author weiye
 * @date 2021/5/19 12:24
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class LeetCode215 {

    class Solution {

        private Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return selectK(nums, 0, nums.length - 1, nums.length - k);
        }

        private int selectK(int[] arr, int left, int right, int k) {
            int index = partition(arr, left, right);
            if (index == k) return arr[index];
            if (index > k) return selectK(arr, left, index - 1, k);
            return selectK(arr, index + 1, right, k);
        }

        private int selectK(int[] arr, int k) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int index = partition(arr, left, right);
                if (index == k) return arr[index];
                if (index > k) {
                    right = index - 1;
                } else {
                    left = index + 1;
                }
            }
            throw new RuntimeException("No Solution");
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
