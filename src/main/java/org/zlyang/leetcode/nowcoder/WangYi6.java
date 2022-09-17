package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-21 19:30
 * @description:
 */
public class WangYi6 {

    public static long getCount(long[] nums, long limit, long target){
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long left, right;
        long divide = sum / target;
        if(sum % target == 0){
            left = sum - target * (divide - 1);
        } else {
            left = sum - target * divide;
        }
        right = target * (divide + 1) - sum;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > left){
                long temp = nums[i] - left;
                if(temp > limit){
                    temp -= ((temp - limit) / target + (temp - limit) % target == 0 ? 0 : 1) * target;
                }
                count += ((temp / target) + (temp % target == 0 ? 0 : 1));
            }
            if(limit - nums[i] >= right){
                count += ((limit - nums[i] - right) / target + 1);
            }
        }
        return count;

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long p = scanner.nextLong();
        long x = scanner.nextLong();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        System.out.println(getCount(nums, p, x));
    }
}
