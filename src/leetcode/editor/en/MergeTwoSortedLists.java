//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists in a one sorted list. The list should be made by splicing
// together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
//
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 9271 👎 913


package leetcode.editor.en;

import dataObj.ListNode;
import tool.Tool;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode node1 = new ListNode(1, 2, 3, 4, 5);
        ListNode node2 = new ListNode(6, 7);
        Tool.print(solution.mergeTwoLists(node1, node2));
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }
            ListNode head = new ListNode(0), next = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    next.next = list1;
                    list1 = list1.next;
                } else {
                    next.next = list2;
                    list2 = list2.next;
                }
                next = next.next;
            }
            next.next = list1 == null ? list2 : list1;
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
