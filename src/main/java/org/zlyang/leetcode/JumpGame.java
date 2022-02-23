package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-23 10:39
 * @description:
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int end = 0;
        for(int i = 0; end < nums.length && i <= end; i++){
            end = Math.max(nums[i] + i, end);
        }
        return end >= nums.length - 1;
    }
}
