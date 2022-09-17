package org.zlyang.leetcode.nowcoder;

import org.zlyang.leetcode.utils.ListNode;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-04-24 20:56
 * @description:
 */
public class Tencent4 {

    private ListNode reverse(ListNode head, ListNode tail){
        ListNode current = head.next;
        ListNode next = current.next;
        head.next = tail;
        current.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return head;
    }

    public ListNode solve (ListNode[] a) {
        // write code here
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode minNode = new ListNode(Integer.MAX_VALUE);
        for (int i = 0; i < a.length; i++) {
            ListNode currentHead = a[i];
            while(currentHead != null){
                if(map.containsKey(currentHead.val)){
                    ListNode mapNode = map.get(currentHead.val);
                    if(mapNode.next == null && currentHead.next != null){
                        map.put(currentHead.val, currentHead);
                    }
                } else {
                    map.put(currentHead.val, currentHead);
                }
                if(currentHead.val < minNode.val){
                    minNode = map.get(currentHead.val);
                }
                currentHead = currentHead.next;
            }
        }

        ListNode newHead = new ListNode(minNode.val);
        int start = newHead.val, next = map.get(newHead.val).next.val;
        ListNode current = newHead;
        while(start != next){
            current.next = new ListNode(next);
            current = current.next;
            next = map.get(next).next.val;
        }
        if(newHead.next.val > current.val){
            newHead = reverse(newHead, current);
        }
        return newHead;
    }
}
