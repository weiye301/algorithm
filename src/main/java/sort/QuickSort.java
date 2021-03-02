package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Random;

/**
 * @author weiye
 * @date 2021/2/24 11:36
 */
public class QuickSort {

    private static Random random = new Random();

    private QuickSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }
        int v = partition(arr, l, r);
        sort(arr, l, v - 1);
        sort(arr, v + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int randomIndex = l + random.nextInt(r - l + 1);
        SortingHelper.swap(arr, l, randomIndex);
        //j标记arr[l+1,j] < v的区间界限
        int j = l;
        //v：数组l位子元素
        E v = arr[l];
        //遍历，如果i位置元素比v大，则将其移动到arr[l+1,j]区间内
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                SortingHelper.swap(arr, i, j);
            }
        }
        SortingHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MERGE_SORT, arr);
        SortingHelper.sortDuration(SortType.QUICK_SORT, arr2);
    }
}
