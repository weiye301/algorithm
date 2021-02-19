package linkedlist;

/**
 * @author weiye
 * @date 2021/2/18 12:06
 */
public class LC206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        public static ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode rev = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return rev;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(head);
        ListNode listNode = Solution.reverseList2(head);
        System.out.println(listNode);
    }
}
