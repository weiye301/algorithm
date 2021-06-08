package offer.array;

/**
 * @author weiye
 * @date 2021/6/8 12:07
 */
public class J57 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            //题目要求必须是两数和，所以不能相等
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return new int[0];
        }
    }
}
