package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-04-09 19:07
 * @description:
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
