package search;

/**
 * @author weiye
 * @date 2021/5/21 10:31
 */
public class BinarySearch {
    private BinarySearch() {
    }

    public static <E extends Comparable<E>> int search(E[] arr, E target) {
//        return search(arr, 0, arr.length - 1, target);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].compareTo(target) == 0) return mid;
            if (arr[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //递归实现二分查找法
    private static <E extends Comparable<E>> int search(E[] arr, int left, int right, E target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid].equals(target)) {
            return mid;
        }
        if (arr[mid].compareTo(target) > 0) {
            return search(arr, left, mid - 1, target);
        }
        return search(arr, mid + 1, right, target);

    }

    //寻找>target的最小值索引
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].compareTo(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //寻找<target的最大值索引
    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        int left = -1;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid].compareTo(target) < 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //数组中有target，则返回target的最大索引值，否则返回>target的最小索引值
    public static <E extends Comparable<E>> int ceil(E[] arr, E target) {
        int upper = upper(arr, target);
        if (upper - 1 >= 0 && arr[upper - 1].compareTo(target) == 0) {
            return upper - 1;
        }
        return upper;
    }

    public static <E extends Comparable<E>> int lowerCeil(E[] arr, E target) {
        int upper = upper(arr, target);
        if (upper - 1 < 0 || arr[upper - 1].compareTo(target) != 0) {
            return upper;
        }
        while (upper - 1 >= 0 && arr[upper - 1].compareTo(target) == 0) {
            upper--;
        }
        return upper;
    }

    public static <E extends Comparable<E>> int lowerFloor(E[] arr, E target) {
        int lower = lower(arr, target);
        if (lower + 1 < arr.length && arr[lower + 1].compareTo(target) == 0) {
            return lower + 1;
        }
        return lower;
    }

    public static <E extends Comparable<E>> int upperFloor(E[] arr, E target) {
        int upper = upper(arr, target);
        return upper - 1;

    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i < 7; i++) {
            System.out.println(lowerFloor(arr, i));
        }
        System.out.println("-----------");
        for (int i = 0; i < 7; i++) {
            System.out.println(upperFloor(arr, i));
        }
    }
}
