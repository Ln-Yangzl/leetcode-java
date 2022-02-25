package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/25 10:37
 */
public class LargestRectangleInHistogram {

    /**
     * O(n^2)超时
     */
//    private int getLeft(int[] heights, int pos){
//        for (int i = pos; i > 0 ; i--) {
//            if(heights[i - 1] < heights[pos]){
//                return i;
//            }
//        }
//        return 0;
//    }
//
//    private int getRight(int[] heights, int pos){
//        for (int i = pos; i < heights.length ; i++) {
//            if(heights[i] < heights[pos]){
//                return i - 1;
//            }
//        }
//        return heights.length - 1;
//    }
//
//    public int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int left = getLeft(heights, i);
//            int right = getRight(heights, i);
//            maxArea = Math.max(maxArea, heights[i] * (right - left + 1));
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleInHistogram o = new LargestRectangleInHistogram();
        System.out.println(o.largestRectangleArea(heights));
    }
}
