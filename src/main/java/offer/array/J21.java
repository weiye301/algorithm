package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 12:09
 */
public class J21 {

    class Solution {
        public int[] exchange(int[] nums) {
            //记录下一个奇数应该存放的位置
            int low = 0;
            //遍历数组的指针
            int fast = 0;

            while (fast < nums.length) {
                //如果fast位置元素是奇数，则和low位置元素交换位置
                if (nums[fast] % 2 == 1) {
                    int tmp = nums[low];
                    nums[low] = nums[fast];
                    nums[fast] = tmp;
                    //low+1 指向下一个奇数存放的位置
                    low++;
                }
                //无论是否交换位置，fast都要遍历下一个元素
                fast++;
            }

            return nums;
        }
    }

    class Solution2 {

        public int[] exchange(int[] nums) {
            //用快速排序
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] % 2 != 0) {
                    left++;
                    continue;
                }
                if (nums[right] % 2 == 0) {
                    right--;
                    continue;
                }
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
            return nums;
        }
    }
}
