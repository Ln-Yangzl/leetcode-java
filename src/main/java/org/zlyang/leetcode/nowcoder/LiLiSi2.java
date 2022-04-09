package org.zlyang.leetcode.nowcoder;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:25
 * @description:
 */
public class LiLiSi2 {
    public long ans (int[] array, int k) {
        // write code here
        Arrays.sort(array);
        int count = 0;
        int left = 0, right = array.length - 1;
        while(left < right){
            while(array[left] + array[right] > k && left < right){
                right--;
            }
            count += (right - left);
            left++;
        }
        return count;
    }
}
