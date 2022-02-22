package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/22 12:05
 */
public class FirstMissingPositive {

    private int changePos(int[] nums, int index){
        int temp = nums[index];
        nums[index] = -1;
        //TODO:把temp独立出来仅赋值
        if(temp < 0 || temp >= nums.length || nums[temp] > nums.length || nums[temp] <= 0){
            return -1;
        }
        nums[0] = nums[temp];
        nums[temp] = temp;
        return temp;
    }

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i && nums[i] > 0 && nums[i] < nums.length){
                for(int next = changePos(nums, i); next != -1; next = changePos(nums, 0));
            }
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, -1, 1};
        FirstMissingPositive o = new FirstMissingPositive();
        System.out.println(o.firstMissingPositive(nums));
    }
}
