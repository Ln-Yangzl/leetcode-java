package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-20 9:43
 * @description:
 */
public class The3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                int low = i + 1, high = nums.length - 1, sum = -nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        The3Sum o = new The3Sum();
        System.out.println(o.threeSum(nums));
    }
}
