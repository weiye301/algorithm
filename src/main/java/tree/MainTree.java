package tree;

/**
 * @author weiye
 * @date 2021/5/26 12:01
 */
public class MainTree {
    public static void main(String[] args) {

        int[] arr = {5, 3, 6, 8, 4, 2};
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
        for (int integer : arr) {
            searchTree.add(integer);
        }
        searchTree.inOrder();
        searchTree.remove(8);
        System.out.println();
        searchTree.inOrder();
    }
}
