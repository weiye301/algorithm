package util;

import java.util.Random;

/**
 * @author weiye
 * @date 2021/1/26 11:15
 * 生成长度为n的int数组
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    /**
     * 生成顺序数组
     * @param n 长度
     * @return 数组
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成乱序数组  值的范围：[0, range)
     * @param n 数组长度
     * @param range 随机数最大边界
     * @return 数组
     */
    public static Integer[] generateRandomArray(int n, int range) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(range);
        }
        return arr;
    }
}
