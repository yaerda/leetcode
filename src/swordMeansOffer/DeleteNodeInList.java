package swordMeansOffer;

import dataObj.ListNode;
import tool.Tool;

public class DeleteNodeInList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 4, 6, 7);
        ListNode toBeDeleted = listNode;
        ListNode toBeDeleted2 = listNode.next;

        ListNode toBeDeleted3 = listNode.next;
        while (toBeDeleted3.next != null) {
            toBeDeleted3 = toBeDeleted3.next;
        }
        ListNode toBeDeleted4 = new ListNode(5);
        Tool.print(listNode.toString());
        new DeleteNodeInList().solution(listNode, toBeDeleted4);
        Tool.print(listNode.toString());
        new DeleteNodeInList().solution(listNode, toBeDeleted3);
        Tool.print(listNode.toString());
        new DeleteNodeInList().solution(listNode, toBeDeleted2);
        Tool.print(listNode.toString());
        new DeleteNodeInList().solution(listNode, toBeDeleted);
        Tool.print(listNode.toString());

    }


    public void solution(ListNode listHead, ListNode toBeDeleted) {
        if (listHead == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else if (listHead.next == null) {
            if (listHead.val.equals(toBeDeleted.val)) {
                listHead.val = null;
            }
        } else {
            ListNode cur = listHead;
            while (cur.next != null) {
                if (cur.next.val.equals(toBeDeleted.val)) {
                    cur.next = null;
                } else {
                    cur = cur.next;
                }
            }
        }
    }
}
