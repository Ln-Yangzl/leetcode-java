package org.zlyang.leetcode.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-24 20:24
 * @description:
 */
public class Tencent3 {

    private static int MOD = 1000000007;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[10001];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int next = scanner.nextInt();
            System.out.println(arr[next]);
        }
    }
}
