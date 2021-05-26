package sort;

import entity.SortType;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Random;

/**
 * @author weiye
 * @date 2021/5/18 10:50
 */
public class QuickSort2 {

    private static Random random = new Random();

    private QuickSort2(){

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort3Ways(arr, 0, arr.length - 1);
    }

    /**
     * 排序数组arr指定区间[left, right]元素
     *
     * @param arr   排序数组
     * @param left  左边界
     * @param right 右边界
     * @param <E>   支持比较的类型
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //将某个元素放到他排好序的位置，并返回该位置索引
        int index = partition2(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
    }

    /**
     * 寻找left位置元素排好序后应该插入的位置，并且该位置左边为小于left 右边为大于left位置元素
     * @param arr 排序数组
     * @param left 左边界
     * @param right 右边界
     * @param <E> 泛型
     * @return left位置元素排好序的位置
     */
    private static <E extends Comparable<E>> int partition(E[] arr, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        SortingHelper.swap(arr, left, randomIndex);
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            //如果i位置元素小于v，则将j+1位置元素和i位置元素交换，以此保证[left+1, j]都是小于v的
            if (arr[i].compareTo(arr[left]) < 0) {
                j++;
                SortingHelper.swap(arr, i, j);
            }
        }
        //最后交换v与j位置元素
        SortingHelper.swap(arr, left, j);
        return j;
    }

    /**
     * 双路快速排序
     * @param arr 排序的数组
     * @param left 左边界
     * @param right 右边界
     * @param <E> 支持比较的泛型
     * @return 排好序元素的索引
     */
    private static <E extends Comparable<E>> int partition2(E[] arr, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        SortingHelper.swap(arr, left, randomIndex);
        //i是左边标定点，j是右边标定点，标定点即当前遍历的元素
        int i = left + 1;
        int j = right;
        while (true) {
            //从i寻找第一个大于等于left的元素
            while (i <= j && arr[i].compareTo(arr[left]) < 0) {
                i++;
            }
            //从j寻找第一个小于等于left的元素
            while (j >=i && arr[j].compareTo(arr[left]) > 0) {
                j--;
            }
            //此时i=j说明该位置元素等于left
            if (i >= j) break;
            //交换i，j
            SortingHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortingHelper.swap(arr, left, j);
        return j;
    }

    private static <E extends Comparable<E>> void sort3Ways(E[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        SortingHelper.swap(arr, left, randomIndex);
        //当前遍历元素
        int i = left + 1;
        //arr[left + 1, lt] < v
        int lt = left;
        //arr[gt, r] > v
        int gt = right + 1;
        //循环停止条件：i>=gt
        while (i < gt) {
            if (arr[i].compareTo(arr[left]) < 0) {
                lt++;
                SortingHelper.swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[left]) > 0) {
                gt--;
                SortingHelper.swap(arr, gt, i);
            } else {
                i++;
            }
        }
        SortingHelper.swap(arr, left, lt);
        sort3Ways(arr, left, lt - 1);
        sort3Ways(arr, gt, right);
    }


    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MERGE_SORT, arr);
        SortingHelper.sortDuration(SortType.QUICK_SORT, arr2);
    }
}
