package leetcode.RemoveLinkedListElement;

import leetcode.util.ListNode;

public class RemoveLinkedListElement {

    public static void main(String[] args) {
        ListNode l2_8 = new ListNode(9);
        ListNode l2_7 = new ListNode(6, l2_8);
        ListNode l2_6 = new ListNode(5, l2_7);
        ListNode l2_5 = new ListNode(4, l2_6);
        ListNode l2_4 = new ListNode(3, l2_5);
        ListNode l2_3 = new ListNode(6, l2_4);
        ListNode l2_2 = new ListNode(2, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);

        ListNode result = removeElements(l2_1, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        return getNext(head, val);
    }

    public static ListNode getNext(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            head = getNext(head.next, val);
        } else {
            head.next = getNext(head.next, val);
        }
        return head;
    }

}
