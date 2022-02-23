package org.zlyang.leetcode;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-02-23 9:13
 * @description:
 */
public class JumpGameII {

    /**
     * 对于每一个直接找最远的
     * @param nums
     * @return
     */
//    public int jump(int[] nums) {
//        int end = 0;
//        int maxPosition = 0;
//        int steps = 0;
//        for(int i = 0; i < nums.length - 1; i++){
//            //找能跳的最远的
//            maxPosition = Math.max(maxPosition, nums[i] + i);
//            if( i == end){ //遇到边界，就更新边界，并且步数加一
//                end = maxPosition;
//                steps++;
//            }
//        }
//        return steps;
//    }


    /**
     * dp solution slow
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++){
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGameII o = new JumpGameII();
        System.out.println(o.jump(nums));
    }
}
