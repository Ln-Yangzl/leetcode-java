package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-26 16:12
 * @description:
 */
public class Meituan2 {

    public static int getMinDiff(int[] points){
        int i = 0, j = points.length - 1;
        int countI = 0, countJ = 0, diff = 0;
        while(i != j){
            int left = Math.abs(diff + points[i] - points[i + 1]);
            int right = Math.abs(diff + points[j] - points[j - 1]);
            if(left > right){
                diff += (points[j] - points[j - 1]);
                j--;
            }else{
                diff += (points[i] - points[i + 1]);
                i++;
            }
        }
        return Math.abs(diff);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] points = new int[num];
        for (int i = 0; i < num; i++) {
            points[i] = scanner.nextInt();
        }
        System.out.println(getMinDiff(points));
    }
}
