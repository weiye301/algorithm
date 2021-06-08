package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 11:33
 */
public class J11 {
    class Solution {
        public int minArray(int[] numbers) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return numbers[left];
        }
    }
}
