package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-16 15:17
 * @description:
 */
public class WangYi2 {

    public static long[] getArr(int len, long max, long sum){
        long[] res = new long[len];
        if(max < len){
            return null;
        }
        long count = 0;
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
            count += res[i];
        }
        if(count > sum){
            return null;
        }
        if(count == sum){
            return res;
        }
        long left = sum - count;
        long currentMax = max;
        for (int i = len - 1; i >= 0; i--){
            if(currentMax - res[i] < left){
                left -= (currentMax - res[i]);
                res[i] = currentMax;
                currentMax--;
            } else {
                res[i] += left;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long max = scanner.nextLong();
        long sum = scanner.nextLong();
        long[] res = getArr(len, max, sum);
        if(res == null){
            System.out.println(-1);
        } else {
            for (long re : res) {
                System.out.print(re + " ");
            }
        }
    }
}
