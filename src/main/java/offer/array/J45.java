package offer.array;

/**
 * @author weiye
 * @date 2021/6/8 10:24
 */
public class J45 {
    class Solution {
        public String minNumber(int[] nums) {
            //将int型的数组转换为字符串类型
            String[] numsStr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsStr[i] = String.valueOf(nums[i]);
            }
            //对字符串数组排序
            sortStringArray(numsStr, 0, numsStr.length - 1);
            //将排好序的数组按顺序拼接返回
            StringBuilder res = new StringBuilder();
            for (String str : numsStr) {
                res.append(str);
            }
            return res.toString();
        }

        private void sortStringArray(String[] data, int left, int right) {
            if (left >= right) return;

            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && (data[j] + data[left]).compareTo(data[left] + data[j]) >= 0) {
                    j--;
                }
                while (i < j && (data[i] + data[left]).compareTo(data[left] + data[i]) <= 0) {
                    i++;
                }

                if (i < j) {
                    String tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
            String tmp = data[j];
            data[j] = data[left];
            data[left] = tmp;

            sortStringArray(data, left, i - 1);
            sortStringArray(data, i + 1, right);
        }
    }
}
