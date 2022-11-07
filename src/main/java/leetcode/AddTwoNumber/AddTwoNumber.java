package leetcode.AddTwoNumber;

import leetcode.util.ListNode;

public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(9);
        ListNode l1_2 = new ListNode(9, l1_3);
        ListNode l1_1 = new ListNode(9, l1_2);

        ListNode l2_4 = new ListNode(9);
        ListNode l2_3 = new ListNode(9, l2_4);
        ListNode l2_2 = new ListNode(9, l2_3);
        ListNode l2_1 = new ListNode(9, l2_2);

        ListNode result = addTwoNumbers(l1_1, l2_1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }



    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int i) {
        if (l1 == null && l2 == null) {
            if (i == 1) {
                l1 = new ListNode(1);

            }
            return l1;
        }

        if (l1 == null) {
            int rest = (l2.val + i) % 10;
            int i2 = l2.val + i >= 10 ? 1 : 0;
            l2.val = rest;
            l2.next = addTwoNumbers(null, l2.next, i2);
            return l2;
        }

        if (l2 == null) {
            int rest = (l1.val + i) % 10;
            int i2 = l1.val + i >= 10 ? 1 : 0;
            l1.val = rest;
            l1.next = addTwoNumbers(l1.next, null, i2);
            return l1;
        }

        int rest = (l1.val + l2.val + i) % 10;
        int i2 = l1.val + l2.val + i >= 10 ? 1 : 0;
        l1.val = rest;
        l1.next = addTwoNumbers(l1.next, l2.next, i2);

        return l1;
    }



}

