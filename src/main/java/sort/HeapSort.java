package sort;

import entity.SortType;
import heap.MaxHeap;
import util.ArrayGenerator;
import util.SortingHelper;

/**
 * @author weiye
 * @date 2021/6/2 15:50
 */
public class HeapSort {

    private HeapSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : arr) {
            maxHeap.add(e);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        if (arr.length <= 1) return;
        //将arr变成最大堆形式
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
        //排序
        for (int i = arr.length - 1; i >= 0; i--) {
            SortingHelper.swap(arr, 0, i);
            siftDown(arr, 0, i);
        }

    }

    /**
     * 对 data[0, n) 形成的最大堆，索引为k的元素，执行下沉操作
     *
     * @param data 数组
     * @param k    下沉的元素索引
     * @param n    下沉的范围
     * @param <E>  泛型
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            //进来后说明一定有左孩子
            int j = 2 * k + 1;
            //j+1就是右孩子索引，如果存在右孩子并且右孩子大于左孩子，那么需要交换的是右孩子
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                //此时j存的是右孩子索引
                j += 1;
            }
            //判断j 和 k的大小 决定是否需要交换
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            //下沉k位置元素
            SortingHelper.swap(data, j, k);
            //继续下沉
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MAX_HEAP_SORT, arr);

        Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.MERGE_SORT, arr2);

        Integer[] arr3 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortDuration(SortType.QUICK_SORT, arr3);
    }
}
