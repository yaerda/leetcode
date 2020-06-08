public class RemoveNthFromEnd {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(6);
        System.out.println(head);

        for (int i = 1; i <= 5; i++) {
            LinkNode next = head.next;
            head.next = new LinkNode(i);
            head.next.next = next;
            System.out.println(head);
        }
        System.out.println(head);
        System.out.println(removeNth(head, 2));
    }

    private static LinkNode removeNth(LinkNode head, int n) {
        LinkNode start = new LinkNode(0);
        LinkNode slow = start, fast = start;
        start.next = head;
        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }
        while (fast!= null) {
            fast = fast.next;
            slow = slow.next;
        }
        //remove not desired element
        slow.next = slow.next.next;
        return head;
    }
}


class LinkNode {
    int val;
    LinkNode next;

    LinkNode() {
    }

    LinkNode(int val) {
        this.val = val;
    }

    LinkNode(int val, LinkNode node) {
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
