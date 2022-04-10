package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author: zlyang
 * @date: 2022-04-10 9:41
 * @description:
 */
public class ReorderList {

    private ListNode reverseList(ListNode head){
        ListNode former = null, current = head, next = head.next;
        while(current != null){
            current.next = former;
            former = current;
            current = next;
            next = next == null ? null : next.next;
        }
        return former;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversHead = reverseList(slow);
        if(prev == null){
            return;
        }
        prev.next = null;
        ListNode leftList = head, rightList = reversHead;
        while(leftList != null){
            ListNode leftNext = leftList.next, rightNext = rightList.next;
            leftList.next = rightList;
            leftList = leftNext;
            rightList.next = leftNext;
            if(leftList == null && rightNext != null){
                rightList.next = rightNext;
            }
            rightList = rightNext;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReorderList o = new ReorderList();
        o.reorderList(head);
    }
}
