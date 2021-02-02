package stack;

/**
 * @author weiye
 * @date 2021/2/2 14:28
 * 1381. 设计一个支持增量操作的栈
 * 请你设计一个支持下述操作的栈。
 * <p>
 * 实现自定义栈类 CustomStack ：
 * <p>
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CustomStack {

    private int[] data;
    private int size;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
        size = 0;
    }

    public void push(int x) {
        if (size == data.length) {
            return;
        }
        data[size] = x;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        size--;
        return data[size];
    }

    public void increment(int k, int val) {
        int min = Math.min(k, size);
        for (int i = 0; i < min; i++) {
            data[i] += val;
        }
    }
}
