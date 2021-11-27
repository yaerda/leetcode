package swordMeansOffer;

import dataObj.ListNode;
import tool.Tool;

public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 4, 5, 6, 7);
        Tool.print(new FindKthToTail().solution(listNode, 8));
    }

    private ListNode solution(ListNode listNode, int k) {
        if (k <= 0 || listNode == null) {
            return null;
        }
        ListNode tailNode = listNode, kNode = listNode;
        int step = 0;
        while (step < k - 1) {
            tailNode = tailNode.next;
            if (tailNode == null) {
                return null;
            }
            step++;
        }
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            kNode = kNode.next;
        }
        return kNode;
    }
}
