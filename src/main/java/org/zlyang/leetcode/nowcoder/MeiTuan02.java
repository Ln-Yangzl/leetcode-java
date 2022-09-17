package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-09-10 16:14
 * @description:
 */
public class MeiTuan02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int zeroCount = 0, sum = 0;
        for (int i = 0; i < total; i++) {
            int num = scanner.nextInt();
            sum += num;
            if (num == 0){
                zeroCount++;
            }
        }
        int optNum = zeroCount;
        sum += zeroCount;
        if(sum == 0){
            optNum++;
        }
        System.out.println(optNum);

    }

}
