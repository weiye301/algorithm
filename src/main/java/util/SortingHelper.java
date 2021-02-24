package util;

import entity.SortType;
import sort.InsertSort;
import sort.MergeSort;
import sort.SelectSort;

/**
 * @author weiye
 * @date 2021/1/26 11:26
 * 辅助测试排序的工具类
 */
public class SortingHelper {

    private SortingHelper() {
    }

    /**
     * 交互位置
     *
     * @param arr 数组
     * @param i   位置1
     * @param j   位置2
     * @param <E> 泛型
     */
    public static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断数组是否从小到大排序
     *
     * @param arr 数组
     * @param <E> 实现了Comparable的类型
     * @return 结果
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试排序算法耗时
     *
     * @param sortType 排序算法类型
     * @param arr      数组
     * @param <E>      实现了Comparable的类型
     */
    public static <E extends Comparable<E>> void sortDuration(SortType sortType, E[] arr) {
        long startTime = System.nanoTime();
        if (sortType.equals(SortType.SELECT_SORT)) {
            SelectSort.sort(arr);
        } else if (sortType.equals(SortType.INSERT_SORT)) {
            InsertSort.sort(arr);
        } else if (sortType.equals(SortType.INSERT_SORT2)) {
            InsertSort.sort2(arr);
        } else if (sortType.equals(SortType.INSERT_SORT3)) {
            InsertSort.sort3(arr);
        } else if (sortType.equals(SortType.MERGE_SORT)) {
            MergeSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortType + " failed!");
        }
        System.out.println(String.format("%s , n = %d : %f s", sortType, arr.length, duration));
    }
}
