package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

/**
 * @author weiye
 * @date 2021/1/27 10:50
 * 插入排序
 */
public class InsertSort {

    private InsertSort() {
    }

    /**
     * 插入排序 从小到大
     *
     * @param arr 要排序的数组
     * @param <E> 可比较类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) >= 0) {
                    break;
                }
                SortingHelper.swap(arr, j, j - 1);
            }
            //方法2
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                SortingHelper.swap(arr, j, j - 1);
//            }
        }
    }

    /**
     * 插入排序 从小到大
     * 优化
     *
     * @param arr 要排序的数组
     * @param <E> 可比较类型
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            E tmp = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp.compareTo(arr[j - 1]) >= 0) {
                    break;
                }
                arr[j] = arr[j - 1];

            }
            arr[j] = tmp;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            E tmp = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp.compareTo(arr[j - 1]) >= 0) {
                    break;
                }
                arr[j] = arr[j - 1];

            }
            arr[j] = tmp;
        }
    }

    /**
     * 插入排序 从小到大
     * 从后往前排序
     *
     * @param arr 要排序的数组
     * @param <E> 可比较类型
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E tmp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length; j ++) {
                if (tmp.compareTo(arr[j + 1]) <= 0) {
                    break;
                }
                arr[j] = arr[j + 1];
            }
            arr[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortDuration(SortType.INSERT_SORT2, arr);
            SortingHelper.sortDuration(SortType.INSERT_SORT3, arr2);
        }
    }
}
