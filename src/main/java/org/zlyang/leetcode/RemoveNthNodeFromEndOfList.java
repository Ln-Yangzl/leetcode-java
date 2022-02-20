package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author: zlyang
 * @date: 2022-02-20 13:42
 * @description:
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        ListNode current = new ListNode(-1, head);
        head = current;
        for(int i = 0; i < n; i++){
            end = end.next;
        }
        while(end != null){
            current = current.next;
            end = end.next;
        }
        current.next = current.next.next;
        return head.next;
    }

}
