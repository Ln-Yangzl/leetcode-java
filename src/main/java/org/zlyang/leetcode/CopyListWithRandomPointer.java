package org.zlyang.leetcode;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-04-09 19:29
 * @description:
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node current = head, newHead = new Node(-1);
        Node copyCurrent = newHead;
        while(current != null){
            Node copyNode = nodeMap.getOrDefault(current, new Node(current.val));
            nodeMap.put(current, copyNode);
            copyCurrent.next = copyNode;
            if(current.random != null){
                copyNode.random = nodeMap.getOrDefault(current.random, new Node(current.random.val));
                nodeMap.put(current.random, copyNode.random);
            }
            current = current.next;
            copyCurrent = copyCurrent.next;
        }
        return newHead.next;
    }
}
