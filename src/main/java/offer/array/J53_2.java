package offer.array;

/**
 * @author weiye
 * @date 2021/6/8 11:58
 */
public class J53_2 {
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}
