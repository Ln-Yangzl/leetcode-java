package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-04 19:48
 * @description:
 */
public class Ali2 {

    // 由于不知道去重算法，便列举去重
    private static String getStr(long a, long b, long c){
        long[] nums = {a,b,c};
        Arrays.sort(nums);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        stringBuilder.append(nums[1]);
        stringBuilder.append(nums[2]);
        return stringBuilder.toString();
    }

    // 判断该种情况能够组成多少个三角形
    public static long getCurrent(long n, long k){
        if(n - k * 2 == k){
            return n / 3;
        } else {
            return n;
        }
    }

    public static long getNum(long n){
        if(n == 3){
            return 1;
        }
        if(n == 4){
            return 0;
        }
        long num = (n - 1) / 2;
        long start = num / 2;
        if(num % 2 != 0 && n % 2 == 0){
            start++;
        }
        long count = 0;
        for (long i = start; i < num; i++) {
            count += getCurrent(n, i+1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        System.out.println(getNum(n));
    }
}
