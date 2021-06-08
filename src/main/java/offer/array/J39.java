package offer.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weiye
 * @date 2021/6/7 14:54
 */
public class J39 {

    /**
     * 摩尔投票法，
     * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int votes = 0;
            int cur = 0;
            for (int num : nums) {
                if (votes == 0) {
                    cur = num;
                }
                votes += num == cur ? 1 : -1;
            }
            return cur;
        }
    }

    /**
     * 用map存每个数字出现的次数，当出现大于一半元素次数的数时返回
     */
    class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int half = nums.length / 2;
            for (int num : nums) {
                Integer count = tmpMap.getOrDefault(num, 1);
                if (count > half) {
                    return num;
                }
                tmpMap.put(num, count + 1);
            }
            return -1;
        }
    }

    /**
     * 先排序，因为一定存在一个数出现的次数大于一半数组长度，所以中间位置的数一定是要求的
     */
    class Solution3 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
