package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

/**
 * @author weiye
 * @date 2021/5/14 10:40
 */
public class MergeSortTest {
    private MergeSortTest() { }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] tmp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, tmp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, E[] tmp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid, tmp);
        sort(arr, mid + 1, right, tmp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, left, right, mid, tmp);
        }
    }

    /*
    合并[left, mid] 和 [mid + 1, right]
    */
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int right, int mid, E[] tmp) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = tmp[j];
                j++;
            } else if (j > right) {
                arr[k] = tmp[i];
                i++;
            } else if (tmp[i].compareTo(tmp[j]) > 0) {
                arr[k] = tmp[j];
                j++;
            } else {
                arr[k] = tmp[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MERGE_SORT, arr);
    }
}
