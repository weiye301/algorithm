package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

/**
 * @author weiye
 * @date 2021/2/19 10:50
 * 归并排序
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 将arr数组排序，使用归并
     *
     * @param arr 要排序的数组
     * @param <E> 支持比较的类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] tmp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, tmp);
    }

    /**
     * 归并排序
     *
     * @param arr 要排序的数组
     * @param l   左边界
     * @param r   右边界
     * @param <E> 类型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] tmp) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid, tmp);
        sort(arr, mid + 1, r, tmp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, tmp);
        }
    }

    /**
     * 合并arr[i, mid] arr[mid+1, r] 两个有序数组
     *
     * @param arr 要排序的数组
     * @param l   左边界
     * @param mid 中间值
     * @param r   右边界
     * @param <E> 支持比较的类型
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] tmp) {
        //将arr[l,r] 的数据复制
        System.arraycopy(arr, l, tmp, l, r - l + 1);
        //i 和 j 分别记录要合并的两个数组此时没有合并的最小索引
        int i = l;
        int j = mid + 1;
        //遍历arr[i, j]，将该部分元素排序
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //此时说明左边数组已经取完，直接放右边数组的数据, 但是要注意l并不是从0开始，而tmp从0开始，所以两个数组有偏差
                arr[k] = tmp[j];
                j++;
            } else if (j > r) {
                //此时说明右边数组已经取完，直接放左边数据，同理，要注意偏差
                arr[k] = tmp[i];
                i++;
            } else if (tmp[i].compareTo(tmp[j]) < 0) {
                //此时说明左边数组的i比右边数组的j小，将左边i位置放入
                arr[k] = tmp[i];
                i++;
            } else {
                //此时说明左边数组的i比右边数组的j大，将右边j位置放入
                arr[k] = tmp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MERGE_SORT, arr);
    }
}
