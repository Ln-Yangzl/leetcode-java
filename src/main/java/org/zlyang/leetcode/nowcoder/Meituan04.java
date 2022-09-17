package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-09-10 17:12
 * @description:
 */
public class Meituan04 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt() % m;
        }
        Set<Integer> res = new HashSet<>();
        int pow = 1;
        for (int i = 0; i < 6; i++) {
            res.add(pow % m);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(findMin(res, nums[i], m, 0));
            System.out.print(" ");
        }
    }

    private static int findMin(Set<Integer> res, int check, int target, int former){
        if(check == 0){
            return former;
        }
        ArrayList<Integer> resArray = new ArrayList<>(res);
        int count = former + 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            int current = check + resArray.get(i);
            if(current == target){
                min = Math.min(min, count);
            }
            if(current < target){
                min = Math.min(min, findMin(res, current, target, count));
            }
        }
        return min;
    }

}
