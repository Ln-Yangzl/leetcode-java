package org.zlyang.leetcode.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-09-10 17:36
 * @description:
 */
public class Meituan04x {

    private static final int LEN = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] res = new int[m];
        int[] R = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            R[i] = (int)((Math.pow(10, (double) i)) % m);
        }
        res[0] = 0;
        for (int i = 1; i < m; i++) {
            res[i] = m - i;
        }
        for (int j = 0; j < 10; j++) {
            for (int k = 1; k < LEN; k++){
                for (int i = 1; i < m; i++){
                    int newI = (i + R[k]) % m;
                    res[i] = Math.min(res[i], res[newI] + 1);
                }
            }
        }


        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[nums[i]]);
            System.out.print(" ");
        }
    }

}
