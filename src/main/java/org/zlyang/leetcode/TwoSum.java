package org.zlyang.leetcode;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-02-19 9:22
 * @description:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int numToFind = target - num;
            if (resultMap.containsKey(numToFind)){
                result[0] = resultMap.get(numToFind);
                result[1] = i;
                return result;
            }
            resultMap.put(num, i);
        }
        return result;
    }
}
