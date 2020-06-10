public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//
//        for (int i = 1; i <= 1; i++) {
//            ListNode next = head.next;
//            head.next = new ListNode(i);
//            head.next.next = next;
//        }
        System.out.println(head);
        System.out.println(removeNth(head, 1));
    }

    private static ListNode removeNth(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode node) {
        this.next = node;
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.val);
        if (this.next != null)
            buffer.append(" -> ").append(this.next);
        return buffer.toString();
    }
}
