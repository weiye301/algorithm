package linkedlist;

/**
 * @author weiye
 * @date 2021/2/3 11:11
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    /**
     * 初始化链表，其中dummyHead是虚拟头结点，他的next才是真正的链表的头结点
     */
    public LinkedList() {
        size = 0;
        dummyHead = new Node(null, null);
    }

    /**
     * 获取链表中节点个数
     *
     * @return 节点个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return 结果
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index处增加节点，这里的index和数组的索引不是一回事，只是为了练习而虚拟的概念
     *
     * @param index 索引
     * @param e     节点信息
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头增加节点
     *
     * @param e 节点信息
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾增加节点
     *
     * @param e 节点信息
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 位置
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表头元素
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾元素
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改index处的元素为e
     *
     * @param index 要修改的位置
     * @param e     要修改的值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 是否包含e
     *
     * @param e 元素
     * @return 结果
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除节点
     * @param index 位置
     * @return 删除的节点
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node removeNode = cur.next;
        cur.next = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                Node delNode = pre.next;
                pre.next = pre.next.next;
                size--;
                delNode.next = null;
                return;
            }
            pre = pre.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
