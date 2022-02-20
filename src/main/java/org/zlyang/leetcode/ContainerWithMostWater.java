package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-20 9:04
 * @description:
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int current = 0;
            if(height[left] < height[right]){
                current = height[left] * (right - left);
                left++;
            } else {
                current = height[right] * (right - left);
                right--;
            }
            res = Math.max(res, current);
        }
        return res;
    }
}
