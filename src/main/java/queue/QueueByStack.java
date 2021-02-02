package queue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weiye
 * @date 2021/2/1 18:25
 * 用栈实现队列
 */
public class QueueByStack {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue);
        myQueue.peek();
        System.out.println(myQueue);
        myQueue.pop();
        System.out.println(myQueue);
        System.out.println(myQueue.empty());
    }

}

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stack2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.removeLast());
            }
        }
        return stack2.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
