package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-22 9:02
 * @description:
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums.length == 0){
            return res;
        }
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left < right){
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                break;
            }
            mid = (left + right) / 2;
        }
        if(nums[mid] == target){
            res[0] = mid;
            res[1] = mid;
            while(res[0] > 0 && nums[res[0]] == target){
                res[0]--;
            }
            while(res[1] < nums.length - 1 && nums[res[1]] == target){
                res[1]++;
            }
            if(nums[res[0]]!=target){
                res[0]++;
            }
            if(nums[res[1]]!=target){
                res[1]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4};
        FindFirstAndLastPositionOfElementInSortedArray o = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] res = o.searchRange(nums, 4);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
