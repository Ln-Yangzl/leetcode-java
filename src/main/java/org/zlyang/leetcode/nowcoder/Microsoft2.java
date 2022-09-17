package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-08-26 20:34
 * @description:
 */
public class Microsoft2 {
    public int solution(int[] A, int M) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(A);
        int max = 1;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(expand(A, i, M), max);
        }
        return max;
    }

    private int expand(int[] arr, int index, int num){
        int count = 1, left = index - 1, right = index + 1;
        int leftNum = arr[index], rightNum = arr[index];
        while(left >= 0){
            if(Math.abs(arr[left] - leftNum) % num == 0){
                leftNum = arr[left];
                count++;
            }
            left--;
        }

        while(right < arr.length){
            if(Math.abs(arr[right] - rightNum) % num == 0){
                rightNum = arr[right];
                count++;
            }
            right++;
        }
        return count;
    }
}
