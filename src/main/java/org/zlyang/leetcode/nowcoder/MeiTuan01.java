package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-09-10 16:02
 * @description:
 */
public class MeiTuan01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(getResult(n, x, y, k));
        }
    }

    private static String getResult(int n, int x, int y, int k){
        double xTime = (double)k / (double)x;
        double yTime = (double) (n - k + 1) / (double) y;
        if (xTime < yTime){
            return "Win";
        } else if(xTime > yTime){
            return "Lose";
        }
        return "Tie";
    }

}
