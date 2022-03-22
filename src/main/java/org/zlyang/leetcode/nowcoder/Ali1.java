package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-04 19:25
 * @description:
 */
public class Ali1 {

    public static int getNum(int edge, int time){
        int count = 1;
        for (int i = 1; i <= time; i++) {
            count += ((i + 1) * edge - edge + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int edge, time;
            edge = scanner.nextInt();
            time = scanner.nextInt();
            count += getNum(edge, time);
        }
        System.out.println(count);
    }
}
