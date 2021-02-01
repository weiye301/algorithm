package stack;

/**
 * @author weiye
 * @date 2021/2/1 10:45
 */
public interface Stack<E> {
    /**
     * 获取栈内元素个数
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 判断是否为空
     *
     * @return 是否
     */
    boolean isEmpty();

    /**
     * 放一个元素
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    E peek();
}
