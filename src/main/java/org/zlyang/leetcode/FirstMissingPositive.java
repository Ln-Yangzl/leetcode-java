package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/22 12:05
 */
public class FirstMissingPositive {

    private int changePos(int[] nums, int pos){
        int current = nums[pos];
        nums[pos] = nums[current - 1];
        nums[current - 1] = current;
        return 0;
    }

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                changePos(nums, i);
            } else {
                i++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        FirstMissingPositive o = new FirstMissingPositive();
        System.out.println(o.firstMissingPositive(nums));
    }
}
