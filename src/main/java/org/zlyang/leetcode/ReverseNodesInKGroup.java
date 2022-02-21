package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 13:50
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = new ListNode(-1, head);
        boolean isChange = false;
        head = current;
        while(current.next != null){
            ListNode prev = current;
            current = current.next;
            ListNode next = current.next;
            int i = 0;
            for(i = 0; i < k - 1 && next != null; i++){
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            // 后面数量不足K, 就将已交换的部分再交换回来
            if(i < k - 1 && !isChange){
                current = prev;
                isChange = true;
            }
        }
        return head.next;
    }
}
