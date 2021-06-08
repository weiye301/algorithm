package offer.array;

/**
 * @author weiye
 * @date 2021/6/8 11:36
 */
public class J53_1 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return 0;

            int i = 0;
            int j = nums.length - 1;
            //二分查找，确定比target大的第一个数，循环条件定义为i<=j，
            //那么如果存在target，i=j时，ij指向的一定是target，
            // 此时跳出循环时i指向的一定是右边界索引，j指向的一定是target
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            int right = i;
            //根据上面的二分查找，可以判断j是否为target来确定数组中是否存在目标值，不存在直接结束
            if (j < 0 || nums[j] != target) return 0;

            //二分查找，确定比target小的最大数
            i = 0;
            j = nums.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] >= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            int left = j;

            return right - left - 1;
        }
    }
}
