package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 13:26
 */
public class SwapNodesInPairs {

    private static final int GROUP_NUM = 2;

    public ListNode swapPairs(ListNode head) {
        ListNode current = new ListNode(-1, head);
        head = current;
        while(current.next != null){
            ListNode prev = current;
            current = current.next;
            ListNode next = current.next;
            for(int i = 0; i < GROUP_NUM - 1 && next != null; i++){
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
        }
        return head.next;
    }
}
