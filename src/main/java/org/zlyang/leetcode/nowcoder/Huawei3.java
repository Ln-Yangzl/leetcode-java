package org.zlyang.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-30 19:55
 * @description:
 */
public class Huawei3 {

    private static class Node{
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(String value){
            this.value = Integer.parseInt(value);
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nodes = s.substring(1, s.length() - 1).split(",");
        if(nodes.length == 0){
            System.out.println(-1);
            return;
        }
        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        Node root = new Node(nodes[0]);
        current.offer(root);
        int index = 1;
        while(index != nodes.length){
            while(!current.isEmpty()){
                Node node = current.poll();
                if(!nodes[index].equals("null")){
                    node.left = new Node(nodes[index]);
                    next.offer(node.left);
                }
                if(!nodes[index + 1].equals("null")){
                    node.right = new Node(nodes[index + 1]);
                    next.offer(node.right);
                }
                index += 2;
            }
            LinkedList<Node> temp = next;
            next = current;
            current = temp;
        }
        System.out.println(root);
    }
}
