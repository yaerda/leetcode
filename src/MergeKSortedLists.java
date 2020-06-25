//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap


import dataObj.ListNode;

import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
//        Solution solution = new MergeKSortedLists().new Solution();
//        ListNode[] listNodes = new ListNode[]{new ListNode(1, 2, 3), new ListNode(2, 3, 4), new ListNode(3, 4, 5)};
//        System.out.println(solution.mergeKLists(listNodes));
        sort();

    }

    private static String[] psn = new String[]{"A", "B", "C"};

    private static void sort() {
        for (int i = 0; i < 3; i++) {
            pick(1, i, "");
        }
    }

    private static void pick(int day, int p, String s) {

        if (day < 7) {
            for (int j = 0; j < 3; j++) {
                if (p != j && s.split(psn[j]).length < 3) {
                    pick(day++, j, s + psn[p]);
                }
            }
        }else {
            System.out.println(s);
        }
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
        public ListNode mergeKLists(ListNode[] lists) {
            TreeSet<Integer> treeSet = new TreeSet<>(Comparator.comparingInt(o -> o));
            Map<Integer, Integer> intMap = new HashMap<>();
            for (ListNode list : lists) {
                ListNode temp = list;
                while (temp != null) {
                    treeSet.add(temp.val);
                    int count = intMap.getOrDefault(temp.val, 0);
                    intMap.put(temp.val, count + 1);
                    temp = temp.next;
                }
            }
            ListNode head = new ListNode(0);
            ListNode temp = head;
            for (Integer integer : treeSet) {
                for (int i = 0; i < intMap.get(integer); i++) {
                    temp.next = new ListNode(integer);
                    temp = temp.next;
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
