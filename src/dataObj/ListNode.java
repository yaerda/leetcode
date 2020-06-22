package dataObj;

public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode() {
    }

//    public ListNode(Integer[] nums) {
//        ListNode n = null;
//        n = this;
//        for (int num : nums) {
//            if (n.val == null) {
//                n.val = num;
//            } else {
//                n.next = new ListNode(num);
//                n = n.next;
//            }
//        }
//    }

    public ListNode(Integer... nums) {
        ListNode n = null;
        n = this;
        for (int num : nums) {
            if (n.val == null) {
                n.val = num;
            } else {
                n.next = new ListNode(num);
                n = n.next;
            }
        }
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode node) {
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