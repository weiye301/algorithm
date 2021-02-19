package stack;

import linkedlist.LinkedList;

/**
 * @author weiye
 * @date 2021/2/4 11:02
 */
public class LinkListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkListStack<Integer> stack = new LinkListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
