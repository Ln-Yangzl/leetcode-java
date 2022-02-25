package org.zlyang.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/25 9:49
 */
public class SearchInRotatedSortedArrayII {

    /**
     * 其实不需要移除重复数字
     * 当[left,mid]出现[1,3,1]情况时
     * 只需要left++即可
     */
    public boolean searchWithDuplicate(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return true;
            }
            //左半段有序
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //出现重复的情况，如此来进行避免
            } else if(nums[start] == nums[mid]){
                start++;
                //右半段有序
            }else{
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * 通过移除重复数组而转换为之前类型
     * @param nums
     * @return
     */
    private int removeDuplicate(int[] nums){
        int pos = 0, next = 0;
        HashSet<Integer> used = new HashSet<>();
        while(next < nums.length){
            if(used.add(nums[next])){
                nums[pos] = nums[next];
                pos++;
            }
            next++;
        }
        return pos;
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = removeDuplicate(nums) - 1;
        int mid = (left + right) / 2;
        while(left < right){
            //有序部分在左边
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] >= target){
                    return Arrays.binarySearch(nums, left, mid + 1, target) >= 0;
                }
                left = mid + 1;
            } else {
                if(nums[mid + 1] <= target && nums[right] >= target){
                    return Arrays.binarySearch(nums, mid + 1, right + 1, target) >= 0;
                }
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return nums[mid] == target;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        SearchInRotatedSortedArrayII o = new SearchInRotatedSortedArrayII();
        System.out.println(o.search(nums, 1));
    }
}
