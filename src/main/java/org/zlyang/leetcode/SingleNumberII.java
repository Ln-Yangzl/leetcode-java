package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-04-09 19:16
 * @description:
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        //考虑每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            //考虑每一个数
            for (int j = 0; j < nums.length; j++) {
                //当前位是否是 1
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            //1 的个数是否是 3 的倍数
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }

}
