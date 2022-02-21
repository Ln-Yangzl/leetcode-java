package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.ListNode;

import java.util.ArrayList;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 8:29
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean finish = false;
        ListNode head = new ListNode(-1, null);
        ListNode current = head;
        ArrayList<ListNode> pos = new ArrayList<>(lists.length);
        for (int i = 0; i < lists.length; i++){
            pos.add(lists[i]);
        }
        while(!finish){
            ListNode nextInsert = new ListNode(Integer.MAX_VALUE, null);
            int listIndex = 0;
            finish = true;
            for(int i = 0; i < lists.length; i++){
                if(pos.get(i) != null){
                    finish = false;
                    if(nextInsert.val > pos.get(i).val){
                        nextInsert = pos.get(i);
                        listIndex = i;
                    }
                }
            }
            if(finish){
                break;
            }
            current.next = nextInsert;
            pos.set(listIndex, pos.get(listIndex).next);
            current = current.next;
            current.next = null;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4,5},{1,3,4},{2,6}};
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (int[] num : nums) {
            ListNode head = new ListNode(-1, null);
            ListNode current = head;
            for (int i : num) {
                ListNode node = new ListNode(i, null);
                current.next = node;
                current = current.next;
            }
            listNodes.add(head.next);
        }
        MergeKSortedLists o = new MergeKSortedLists();
        System.out.println(o.mergeKLists(listNodes.toArray(new ListNode[0])));
    }
}
