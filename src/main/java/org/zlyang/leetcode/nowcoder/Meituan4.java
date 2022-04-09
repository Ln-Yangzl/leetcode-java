package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-26 17:08
 * @description:
 */
public class Meituan4 {

//    private static int frac(int num){
//        while(num != 1){
//            num *= (num - 1);
//            num--;
//        }
//        return num;
//    }

    private static int getNums(int total, int target){
        if(target <= 0 || target == total){
            return 1;
        }
        if(total == 0 || total < target){
            return 0;
        }
        long up = 1, down = 1;
        for (int i = 1; i < target; i++) {
            down *= i;
        }
        for (int i = total; i > total - target; i--) {
            up *= i;
        }
        return (int) (down / up);
    }

    public static int getMidSum(int[] nums){
        int sum = 0, maxSide = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= maxSide; j++) {
                sum += nums[i] * getNums(i, j) * getNums(nums.length - i - 2, j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(getMidSum(nums));
    }
}
