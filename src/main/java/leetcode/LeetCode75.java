package leetcode;

/**
 * @author weiye
 * @date 2021/5/19 11:49
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class LeetCode75 {

    class Solution {

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public void sortColors(int[] nums) {
            int i = 0;
            int zero = -1;
            int two = nums.length;
            while (i < two) {
                if (nums[i] == 0) {
                    zero++;
                    swap(nums, zero, i);
                    i++;
                } else if (nums[i] == 2) {
                    two--;
                    swap(nums, two, i);
                } else {
                    i++;
                }
            }
        }


    }

}
