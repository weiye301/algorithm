package queue;

/**
 * @author weiye
 * @date 2021/2/1 15:18
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] arr;
    /**
     * 队首元素所在的索引
     */
    private int front;
    /**
     * 下一个添加元素的索引
     */
    private int tail;
//    private int size;

    public LoopQueue(int capacity) {
        arr = (E[]) new Object[capacity + 1];

    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return arr.length - 1;
    }

    @Override
    public int getSize() {
        int size = 0;
        if (tail >= front) {
            size = tail - front;
        } else {
            size = arr.length - (front - tail);
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % arr.length == front) {
            resize(getCapacity() * 2);
        }
        arr[tail] = e;
        tail = (tail + 1) % arr.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        E ret = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return arr[front];
    }

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newArr[i] = arr[(i + front) % arr.length];
        }
        tail = getSize();
        front = 0;
        arr = newArr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d, data = ", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % arr.length) {
            res.append(arr[i]);
            if ((i + 1) % arr.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
