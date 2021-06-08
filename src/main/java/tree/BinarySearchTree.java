package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weiye
 * @date 2021/5/26 11:19
 * 不包含重复元素的二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 二分搜索树添加一个元素，递归
     *
     * @param node 根节点
     * @param e    插入的元素
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void BFS() {
        if (root == null) {
            return;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public E getMinValue() {
        if (size == 0) {
            throw new IllegalArgumentException("EMPTY");
        }
        return getMinNode(root).e;
    }

    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    public E removeMinNode() {
        E res = getMinValue();
        root = removeMinNode(root);
        return res;
    }

    /**
     * 删除最小的节点
     * @param node 树
     * @return 删除最小节点后的树
     */
    private Node removeMinNode(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    public E getMaxValue() {
        if (size == 0) {
            throw new IllegalArgumentException("EMPTY");
        }
        return getMaxNode(root).e;
    }

    /**
     * 获取最大的节点
     * @param node 树
     * @return 最大的节点
     */
    private Node getMaxNode(Node node) {
        //最大的节点即为右子树遍历到底
        if (node.right == null) {
            return node;
        }
        return getMaxNode(node.right);
    }

    public E removeMaxNode() {
        E res = getMaxValue();
        root = removeMaxNode(root);
        return res;
    }

    /**
     * 删除最大的节点
     * @param node 要删除的树
     * @return 删除最大节点后的树
     */
    private Node removeMaxNode(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxNode(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除某个元素
     * @param node 节点
     * @param e 删除的元素
     * @return 删除后的节点
     */
    private Node remove(Node node, E e) {
        if (node == null) return null;

        //如果e比当前节点大，找右子树
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            //e比当前节点小，找左子树
            node.left = remove(node.left, e);
            return node;
        } else { //当前节点为要删除的
            //如果只有右子树，直接返回右子树
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //只有左子树，直接返回左子树
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子树都有，则将当前节点右子树中最小的元素取代当前节点，以此保证二分搜索树特性
            //获取右子树中最小的节点
            Node rightMinNode = getMinNode(node.right);
            //使用右子树最小节点取代当前节点，注意：当前节点右子树的最小节点需要删除(因为他会取代当前节点)
            rightMinNode.right = removeMinNode(node.right);
            rightMinNode.left = node.left;
            //将删除的节点取消指针
            node.left = node.right = null;
            //返回取代删除节点元素后的节点
            return rightMinNode;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}