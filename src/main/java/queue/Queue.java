package queue;

/**
 * @author weiye
 * @date 2021/2/1 14:50
 */
public interface Queue<E> {

    /**
     * 获取元素个数
     * @return 元素个数
     */
    int getSize();

    /**
     * 队列是否为空
     * @return 结果
     */
    boolean isEmpty();

    /**
     * 队列增加元素
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 移除队列首元素
     * @return 移除的元素
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return 对应元素
     */
    E getFront();
}
