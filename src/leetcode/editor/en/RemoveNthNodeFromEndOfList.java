//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 7649 👎 382


package leetcode.editor.en;

import dataObj.ListNode;
import tool.Tool;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 4, 5, 6, 7);
        Tool.print(new RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(listNode, 7));
        Tool.print(new RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(listNode, 2));
        Tool.print(new RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(listNode, 1));
        Tool.print(new RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(listNode, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n <= 0) {
                return null;
            }
            ListNode zero = new ListNode(0);        //前部增加一个头结点，方便删除本来的头节点
            ListNode fast = zero, slow = zero;
            slow.next = head;

            for (int i = 1; i <= n + 1; i++) {          // 让 快的走到n+1处，则慢的next即为要删除的
                if (fast == null) {
                    return head;
                }
                fast = fast.next;
            }
            while (fast != null) {                     // 如果快的还没走完，先走完
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;                 //删除慢的next，即N节点
            return zero.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
