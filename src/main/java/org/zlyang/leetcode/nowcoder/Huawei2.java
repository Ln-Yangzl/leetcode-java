package org.zlyang.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-30 19:26
 * @description:
 */
public class Huawei2 {

    private static class Node{
        int i;
        int j;

        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int startI = scanner.nextInt();
        int startJ = scanner.nextInt();
        int endI = scanner.nextInt();
        int endJ = scanner.nextInt();
        int blockNum = scanner.nextInt();
        int[][] map = new int[n][m];
        map[startI][startJ] = -1;
        for (int i = 0; i < blockNum; i++) {
            int blockI = scanner.nextInt();
            int blockJ = scanner.nextInt();
            map[blockI][blockJ] = -1;
        }
        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        current.offer(new Node(startI, startJ));
        int distance = 0, count = 0;
        while(count == 0){
            while(!current.isEmpty()){
                Node node = current.poll();
                if(node.i == endI && node.j == endJ){
                    count++;
                }
                map[node.i][node.j] = -1;
                if(node.i != 0 && map[node.i - 1][node.j] == 0){
                    next.offer(new Node(node.i - 1, node.j));
                }
                if(node.i != n - 1 && map[node.i + 1][node.j] == 0){
                    next.offer(new Node(node.i + 1, node.j));
                }
                if(node.j != 0 && map[node.i][node.j - 1] == 0){
                    next.offer(new Node(node.i, node.j - 1));
                }
                if(node.j != m - 1 && map[node.i][node.j + 1] == 0){
                    next.offer(new Node(node.i, node.j + 1));
                }
            }
            distance++;
            LinkedList<Node> temp = next;
            next = current;
            current = temp;
        }
        System.out.println(count + " " + (distance - 1));
    }
}
