package array;

/**
 * @author weiye
 * @date 2021/1/28 11:32
 */
public class ArrayTest {
    public static void main(String[] args) {
        int n = 5;
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        System.out.println(arr);
        arr.add(n);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);

    }
}
