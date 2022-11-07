package leetcode.mergeTwoSortedList;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        ListNode l1_3 = new ListNode(4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(1, l1_2);

        ListNode l2_4 = new ListNode(4);
        ListNode l2_3 = new ListNode(3, l2_4);
        ListNode l2_2 = new ListNode(3, l2_3);
        ListNode l2_1 = new ListNode(1, l2_2);

        ListNode result = mergeTwoLists(l1_1, l2_1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // 1 -2 -4
    // 1- 3- 6
    // 1- 1- 2- 3 -4- 6

    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
//        if (node1 == null) return node2;
//        if (node2 == null) return node1;

        ListNode ref = null;
        ListNode last = null;

        while (true) {

            if (node1 == null && node2 == null) return ref;
            else if (node2 == null) {
                if (ref == null) {
                    ref = node1;
                    last = node1;
                } else {
                    last.next = node1;
                    last = node1;
                }
                node1 = node1.next;
            } else if (node1 == null) {
                if (ref == null) {
                    ref = node2;
                    last = node2;
                } else {
                    last.next = node2;
                    last = node2;
                }
                node2 = node2.next;
            }

            if (node1.val < node2.val) {
                if (ref == null) {
                    ref = node1;
                    last = node1;
                } else {
                    last.next = node1;
                    last = node1;
                }
                node1 = node1.next;
            } else {
                if (ref == null) {
                    ref = node2;
                    last = node2;
                } else {
                    last.next = node2;
                    last = node2;
                }
                node2 = node2.next;
            }
        }

//
//        if (node1.val < node2.val) {
//            node1.next = mergeTwoLists(node1.next, node2);
//            return node1;
//        } else {
//            node2.next = mergeTwoLists(node1, node2.next);
//            return node2;
//        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
