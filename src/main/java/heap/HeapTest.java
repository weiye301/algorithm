package heap;

import java.util.Random;

/**
 * @author weiye
 * @date 2021/6/2 15:44
 */
public class HeapTest {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int [] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IndexOutOfBoundsException("ERROR!!!!");
            }
        }
        System.out.println("finish");
    }
}
