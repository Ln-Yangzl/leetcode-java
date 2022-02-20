package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 9:38
 * @description:
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1, null);
        ListNode current = head;
        boolean carry = false;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry ? 1 : 0;
            carry = false;
            if(sum >= 10){
                carry = true;
                sum -= 10;
            }
            current.next = new ListNode(sum, null);
            current = current.next;
        }
        if(carry){
            current.next = new ListNode(1, null);
        }
        return head.next;
    }
}
