package queue;

/**
 * @author weiye
 * @date 2021/2/1 15:59
 */
public class QueueTest {

    private static double testQueue(Queue<Integer> queue, int count){
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        Queue<Integer> loopQueue = new LoopQueue<>();
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> linkedQueue = new LinkedListQueue<>();
        int count = 100000;
        double loopTime = testQueue(loopQueue, count);
        double arrayTime = testQueue(arrayQueue, count);
        double linkedTime = testQueue(linkedQueue, count);
        System.out.println("loopTime: " + loopTime);
        System.out.println("arrayTime: " + arrayTime);
        System.out.println("linkedTime: " + linkedTime);
    }
}
