package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-22 15:26
 * @description:
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxHeight = 0, pos = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
                pos = i;
            }
        }
        int water = height.length * maxHeight - maxHeight;
        int nextHeight = 0;
        for(int i = 0; i < pos; i++){
            if(nextHeight < height[i]){
                nextHeight = height[i];
            }
            water -= (height[i] + maxHeight - nextHeight);
        }
        nextHeight = 0;
        for(int i = height.length - 1; i > pos; i--){
            if(nextHeight < height[i]){
                nextHeight = height[i];
            }
            water -= (height[i] + maxHeight - nextHeight);
        }
        return water;
    }
}
