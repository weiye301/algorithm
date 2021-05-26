package leetcode;

import java.util.Arrays;

/**
 * @author weiye
 * @date 2021/5/25 10:19
 */
public class LeetCode875 {

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = Arrays.stream(piles).max().getAsInt();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (eatingTime(piles, mid) <= h) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int eatingTime(int[] piles, int k) {
            int res = 0;
            for (int pile : piles) {
                res += pile / k + (pile % k > 0 ? 1 : 0);
            }
            return res;
        }
    }
}
