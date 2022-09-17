package org.zlyang.leetcode.nowcoder;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-16 15:52
 * @description:
 */
public class WangYi4 {

    private static long getWight(long value1, long value2){
        long res = value1 * value2;
        long count = 0;
        while(true){
            if(res % 10 == 0){
                count++;
                res /= 10;
            } else {
                break;
            }
        }
        return count;
    }

    private static long getHigh(long value1){
        long res = value1;
        while(true){
            if(res % 10 == 0){
                res /= 10;
            } else {
                break;
            }
        }
        return res;
    }

    public static long getRes(long[] nums){
        long[][] record = new long[nums.length][nums.length];
        long[][] numRecord = new long[nums.length][nums.length];
        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long currentHigh = getHigh(nums[i]);
            long currentValue = getWight(nums[i], 1);
            for (int j = i; j < nums.length; j++){
                if(i == j){
                    record[i][j] = getWight(nums[i], 1);
                    numRecord[i][j] = nums[i] / (long)Math.pow(10, record[i][j]) ;
                }
                else if(j - 1 == i){
                    record[i][j] = getWight(nums[i], nums[j]);
                    numRecord[i][j] = (nums[i] * nums[j]) / (long)Math.pow(10, record[i][j]) ;
                } else {
                    long temp = getWight(currentHigh, numRecord[i + 1][j]);
                    record[i][j] = temp + currentValue + record[i + 1][j];
                    numRecord[i][j] = currentHigh * numRecord[i + 1][j] / (long)Math.pow(10, temp);
                }
                res += record[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long[] nums = new long[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextLong();
        }
        System.out.println(getRes(nums));
    }
}
