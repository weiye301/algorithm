package linkedlist;

/**
 * @author weiye
 * @date 2021/2/3 15:02
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2,666);
        System.out.println(list);
        System.out.println(list.getLast());
        System.out.println(list.contains(11));
        list.set(5, -1);
        System.out.println(list);
        System.out.println(list.remove(2));
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}
