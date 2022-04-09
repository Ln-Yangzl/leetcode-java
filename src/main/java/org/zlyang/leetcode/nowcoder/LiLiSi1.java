package org.zlyang.leetcode.nowcoder;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:17
 * @description:
 */
public class LiLiSi1 {
    public ListNode formatList (ListNode head) {
        // write code here
        ListNode current = head;
        boolean change = true;
        while(current.next != null && current != null){
            if(change){
                current = current.next;
            } else {
                ListNode temp = current.next;
                current.next = current.next.next;
                temp.next = head;
                head = temp;
            }
            change = !change;
        }
        return head;
    }
}
