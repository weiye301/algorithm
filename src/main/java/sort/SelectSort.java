package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

/**
 * @author weiye
 * @date 2021/1/26 10:35
 * 选择排序
 */
public class SelectSort {

    private SelectSort() {
    }

    /**
     * 从前往后排序
     * 顺序,时间复杂度：O(n^2)
     *
     * @param arr 数组
     * @param <E> 泛型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 最小值的索引
            int minIndex = i;
            // 找[i,arr.length)里的最小值索引
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换值
            SortingHelper.swap(arr, i, minIndex);
        }
    }

    /**
     * 从后往前排序
     * 顺序,时间复杂度：O(n^2)
     *
     * @param arr 数组
     * @param <E> 泛型
     */
    public static <E extends Comparable<E>> void sortFromLater(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            SortingHelper.swap(arr, i, maxIndex);
        }
    }


    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortDuration(SortType.SELECT_SORT, arr);
        }

    }
}
