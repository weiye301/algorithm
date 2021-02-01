package stack;

import array.MyArray;

/**
 * @author weiye
 * @date 2021/2/1 10:49
 */
public class ArrayStack<E> implements Stack<E> {

    private MyArray<E> array;

    public ArrayStack() {
        array = new MyArray<>();
    }

    public ArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.add(e);
    }

    @Override
    public E pop() {
        return array.remove();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
