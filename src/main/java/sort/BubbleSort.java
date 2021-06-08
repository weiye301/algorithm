package sort;

import util.SortingHelper;

/**
 * @author weiye
 * @date 2021/6/4 10:32
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    SortingHelper.swap(data, j, j + 1);
                }
            }
        }
    }
}
