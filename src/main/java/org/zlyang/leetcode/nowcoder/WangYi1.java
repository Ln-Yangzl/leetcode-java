package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-16 15:01
 * @description:
 */
public class WangYi1 {

    public static void graphOut(int n){
        StringBuilder point = new StringBuilder();
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n; i++) {
            point.append(".");
            start.append("*");
        }
        int leftCount = n, rightCount = n;
        for (int i = 0; i < n; i++) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int j = 0; j < leftCount - i; j++) {
                left.append(".");
            }
            for (int j = 0; j < rightCount + i; j++) {
                right.append("*");
            }
            StringBuilder res = new StringBuilder();
            res.append(left).append(right).append(right).append(left);
            System.out.println(res);
        }
        StringBuilder mid = new StringBuilder();
        mid.append(start).append(point).append(point).append(start);
        for (int i = 0; i < 2*n; i++) {
            System.out.println(mid);
        }
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int j = 0; j < leftCount - i; j++) {
                left.append(".");
            }
            for (int j = 0; j < rightCount + i; j++) {
                right.append("*");
            }
            StringBuilder res = new StringBuilder();
            res.append(left).append(right).append(right).append(left);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        graphOut(num);
    }
}
