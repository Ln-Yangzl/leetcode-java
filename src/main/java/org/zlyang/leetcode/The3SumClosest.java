package org.zlyang.leetcode;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-02-20 10:03
 * @description:
 */
public class The3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                int low = i + 1, high = nums.length - 1, sum = target - nums[i];
                while(low < high){
                    int currentDiff = sum - (nums[low] + nums[high]);
                    if(currentDiff == 0){
                        return target;
                    } else if(currentDiff > 0) {
                        low++;
                    } else {
                        high--;
                    }
                    if(Math.abs(currentDiff) < Math.abs(diff)){
                        diff = Math.abs(currentDiff);
                        res = target - currentDiff;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        The3SumClosest o = new The3SumClosest();
        System.out.println(o.threeSumClosest(nums, 1));
    }
}
