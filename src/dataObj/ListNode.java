package dataObj;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode node) {
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