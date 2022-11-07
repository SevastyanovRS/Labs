package leetcode.SwapNodesInPairs;

import leetcode.util.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode l2_4 = new ListNode(4);
        ListNode l2_3 = new ListNode(3, l2_4);
        ListNode l2_2 = new ListNode(2, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);

        ListNode result = swapPairs(l2_1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next != null) {
            ListNode temp = head.next;
            head.next = swapPairs(head.next.next);
            temp.next = head;
            return temp;
        }
        return head;
    }

}
