package queue;

import array.MyArray;

/**
 * @author weiye
 * @date 2021/2/1 14:52
 */
public class ArrayQueue<E> implements Queue<E> {

    private MyArray<E> array;

    public ArrayQueue(){
        array = new MyArray<>();
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
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }
}
