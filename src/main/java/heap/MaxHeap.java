package heap;

import array.MyArray;

/**
 * @author weiye
 * @date 2021/6/2 15:09
 */
public class MaxHeap<E extends Comparable<E>> {
    private MyArray<E> data;

    public MaxHeap() {
        data = new MyArray<>();
    }

    public MaxHeap(int capacity) {
        data = new MyArray<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new MyArray<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取传入索引的父亲节点索引
     * @param index 要获取父亲节点的索引
     * @return 父亲节点索引位置
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //获取index的左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //获取index的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮k位置元素，保证符合完全二叉树定义，即对于父节点，他一定大于左右子树
     * @param k 判断的元素索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("null.");
        }
        return data.get(0);
    }

    public E extractMax() {
        E res = findMax();
        data.swap(0, data.getSize() - 1);
        data.remove();
        siftDown(0);
        return res;
    }

    /**
     * 下沉k位置元素，保证符合完全二叉树定义，即对于父节点，他一定大于左右子树
     * @param k 判断的元素索引
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //进来后说明一定有左孩子
            int j = leftChild(k);
            //j+1就是右孩子索引，如果存在右孩子并且右孩子大于左孩子，那么需要交换的是右孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //此时j存的是右孩子索引
                j += 1;
            }
            //判断j 和 k的大小 决定是否需要交换
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            //下沉k位置元素
            data.swap(j, k);
            //继续下沉
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素，并替换成元素e
     * @param e 替换成元素e
     * @return 最大的元素
     */
    public E replace(E e) {
        E res = findMax();
        data.set(0, e);
        siftDown(0);
        return res;
    }
}
