package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author: zlyang
 * @date: 2022-04-10 9:21
 * @description: 快慢指针的推导可参看https://leetcode.wang/leetcode-142-Linked-List-CycleII.html
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null){
            if(fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode meet = fast;
                while(meet != head){
                    meet = meet.next;
                    head = head.next;
                }
                return meet;
            }
        }
        return null;
    }
}
