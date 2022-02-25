package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/25 10:37
 */
public class LargestRectangleInHistogram {

    private int getLeft(int[] heights, int pos){
        for (int i = pos; i > 0 ; i--) {
            if(heights[i - 1] < pos){
                return i;
            }
        }
        return 0;
    }

    private int getRight(int[] heights, int pos){
        for (int i = pos; i > 0 ; i--) {
            if(heights[i - 1] < pos){
                return i;
            }
        }
        return 0;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {

        }
    }
}
