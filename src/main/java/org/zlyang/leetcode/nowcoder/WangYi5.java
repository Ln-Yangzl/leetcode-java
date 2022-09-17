package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-21 18:59
 * @description:
 */
public class WangYi5 {

    public static void fill(int i, int j, int n, int way1, int way2, char[][] board){
        for (int k = 0; k < n; k++) {
            board[i + k*way1][j] = '*';
            board[i + k*way1][j + k*way2] = '*';
        }
        for (int k = 0; k < n; k++) {
            board[i + (n-1)*way1][j + k*way2] = '*';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] chars = new char[2 * n - 1][2 * n - 1];
        fill(0, 0, n, 1, 1, chars);
        fill(n - 1, n - 1, n, -1, 1, chars);
        fill(n - 1, n - 1, n, 1, -1, chars);
        fill(2*n-2, 2*n-2, n, -1, -1, chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == '*'){
                    System.out.print('*');
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
