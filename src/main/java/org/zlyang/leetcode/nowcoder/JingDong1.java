package org.zlyang.leetcode.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-02 19:25
 * @description:
 */
public class JingDong1 {

    private static void getTarget(long start, String ops){
        long low = start, high = 0;
        for (int i = 0; i < ops.length(); i++) {
            switch (ops.charAt(i)){
                case 'U':
                    low /= 2;
                    high /= 2;
                    break;
                case 'L':
                    low *= 2;
                    high *= 2;
                    break;
                case 'R':
                    low = low * 2 + 1;
                    high *= 2;
                    break;
                default:
                    start = 0;
                    break;
            }
            if(low > 1000000000000000000L){
                high += (low % 1000000000000000000L);
                low /= 1000000000000000000L;
            }
        }
        if(high == 0){
            System.out.println(low);
        } else {
            System.out.println(String.valueOf(high) + low);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextInt();
        long start = scanner.nextLong();
        scanner.nextLine();

        String s = scanner.nextLine();
        getTarget(start, s);
    }
}
