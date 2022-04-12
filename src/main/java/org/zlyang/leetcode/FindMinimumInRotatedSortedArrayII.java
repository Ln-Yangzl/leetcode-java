package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-04-10 15:32
 * @description:
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int min = nums[0];
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[start] < nums[mid]){
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else if(nums[start] == nums[mid]){
                min = Math.min(min, nums[start]);
                start++;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
