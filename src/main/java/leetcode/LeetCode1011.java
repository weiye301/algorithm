package leetcode;

import java.util.Arrays;

/**
 * @author weiye
 * @date 2021/5/25 10:40
 */
public class LeetCode1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (runDays(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int runDays(int[] weights, int size) {
            int days = 0;
            int num = 0;
            for (int weight : weights) {
                if (num + weight <= size) {
                    num += weight;
                } else {
                    days++;
                    num = weight;
                }
            }
            days++;
            return days;
        }
    }
}
