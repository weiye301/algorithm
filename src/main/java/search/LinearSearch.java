package search;

/**
 * @author weiye
 * @date 2021/1/25 10:37
 * 线性查找
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] arr, E target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 12, 5, 1, 32, 65};
        int index = LinearSearch.search(arr, 15);
        System.out.println(index);
    }
}
