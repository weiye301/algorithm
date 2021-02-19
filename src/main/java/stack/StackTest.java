package stack;

/**
 * @author weiye
 * @date 2021/2/1 12:21
 */
public class StackTest {
    public static void main(String[] args) {
        int count = 1000000;

        Stack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, count);
        System.out.println("arrayStack: " + time1);

        Stack<Integer> linkedStack = new LinkListStack<>();
        double time2 = testStack(linkedStack, count);
        System.out.println("linkedStack: " + time2);
    }

    private static double testStack(Stack<Integer> stack, int count){
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
