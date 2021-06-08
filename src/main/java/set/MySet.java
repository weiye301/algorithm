package set;

/**
 * @author weiye
 * @date 2021/6/1 10:44
 */
public interface MySet<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
