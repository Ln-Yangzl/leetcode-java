package org.zlyang.leetcode;



/**
 * @author: zlyang
 * @date: 2022-02-21 16:40
 * @description:
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pos = nums.length - 1;
        while(pos != 0){
            if(nums[pos - 1] < nums[pos]){
                break;
            }
            pos--;
        }
        if(pos == 0){
            reverse(nums, 0, nums.length);
            return;
        }
        pos--;
        int i;
        for(i = pos + 1; i < nums.length - 1; i++){
            if(nums[i] > nums[pos] && nums[i + 1] <= nums[pos]){
                break;
            }
        }
        swap(nums, pos, i);
        reverse(nums, pos + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums, int begin, int end){
        end--;
        while(begin < end){
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        NextPermutation o = new NextPermutation();
        o.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
