public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumListNode(l1, l2, 0);
    }

    public ListNode sumListNode(ListNode l1, ListNode l2, int n) {
        int l1_val = l1 == null ? 0 : l1.val;
        int l2_val = l2 == null ? 0 : l2.val;
        int sum = l1_val + l2_val + n;
        int v1 = sum % 10;
        int v2 = sum / 10;

        ListNode sumNode = new ListNode(v1);
        if (v2 > 0 || l1.next != null || l2.next != null) {
            l1.next = l1.next == null ? new ListNode(0) : l1.next;
            l2.next = l2.next == null ? new ListNode(0) : l2.next;
            sumNode.next = sumListNode(l1.next, l2.next, v2);

        }
        System.out.print(sumNode.val);
        return sumNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
