package array;


import org.omg.CORBA.Object;

/**
 * @author weiye
 * @date 2021/1/28 11:05
 */
public class MyArray<E> {

    /**
     * 数组
     */
    private E[] data;
    /**
     * 数组内元素个数
     */
    private int size;

    /**
     * 默认创建容量为10的数组
     */
    public MyArray() {
        this(10);
    }

    /**
     * 创建容量为capacity的数组
     *
     * @param capacity 容量
     */
    public MyArray(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public MyArray(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取数组的元素个数
     *
     * @return 个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否数组是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 往数组最后添加元素
     *
     * @param e 要添加的元素
     */
    public void add(E e) {
        add(size, e);
    }

    /**
     * 在数组头添加元素
     *
     * @param e 添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 往数组index索引位置添加元素e
     *
     * @param index 要插入的位置
     * @param e     要插入的元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed! index is error argument.");
        }

        if (size == data.length) {
            resize(size * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 获取index位置的元素
     *
     * @param index 索引
     * @return 索引对应的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed! index is error.");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index处的元素为e
     *
     * @param index 索引
     * @param e     修改的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed! index is error.");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含e
     *
     * @param e 元素
     * @return 是否包含
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找e所在位置索引，不存在返回-1
     *
     * @param e 寻找的元素
     * @return 索引
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! index is error.");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 移除最后一个元素
     *
     * @return 删除的元素
     */
    public E remove() {
        return remove(size - 1);
    }

    /**
     * 移除第一个元素
     *
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除第一个元素e
     *
     * @param e 删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IndexOutOfBoundsException("index out of bounds.");
        }
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array: size = %d, capacity = %d, data = ", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
