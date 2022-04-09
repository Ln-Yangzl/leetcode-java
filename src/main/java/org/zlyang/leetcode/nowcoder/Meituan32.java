package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-26 17:42
 * @description:
 */
public class Meituan32 {

    private static int max;

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void helper(int[] nums, int count, int start){
        for (int i = start; i >= 0; i--) {
            count += nums[i];
            if(count % 7 == 0){
                max = Math.max(count, max);
            }
            helper(nums, count, i - 1);
            count -= nums[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        max = 0;
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        helper(ints, 0, ints.length - 1);
        System.out.println(max);
    }
}
