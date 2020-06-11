import dataObj.ListNode;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l1Temp = l1;
        ListNode l2 = new ListNode(0);
        ListNode l2Temp = l2;
        for (int i : new int[] { 1, 2, 3 }) {
            l1Temp.next = new ListNode(i);
            l1Temp = l1Temp.next;
        }
        for (int i : new int[] { 1, 3, 4 }) {
            l2Temp.next = new ListNode(i);
            l2Temp = l2Temp.next;
        }
        System.out.println("L1: " + l1);
        System.out.println("L2: " + l2);

        System.out.println("merge: " + merge(l1, l2));

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode lm = new ListNode(0);
        ListNode lc = lm;
        while (l1 != null || l2 != null) {
            int a;
            if (l1 == null) {
                a = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    a = l1.val;
                    l1 = l1.next;
                } else {
                    a = l2.val;
                    l2 = l2.next;
                }
            }
            lc.next = new ListNode(a);
            lc = lc.next;
        }
        lm = lm.next;
        return lm;
    }
}
