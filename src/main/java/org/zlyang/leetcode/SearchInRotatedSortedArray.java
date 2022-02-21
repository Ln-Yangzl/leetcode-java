package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 19:18
 */
public class SearchInRotatedSortedArray {
    /**
     * 用二分法先找出分界点，再查找（找分界点时用二分法总是会存在只剩2个数时左右无限循环问题）
     * @param args
     */
//    public int search(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int mid = (left + right) / 2;
//        while(left < right){
//            if(nums[mid] < nums[right]){
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//            mid = (left + right) / 2;
//        }
//        int pos = mid;
//        left = 0;
//        right = nums.length - 1;
//        mid = (left + right) / 2;
//        while(left <= right){
//            if(nums[(mid + pos) % nums.length] < target){
//                left = mid + 1;
//            } else if(nums[(mid + pos) % nums.length] > target) {
//                right = mid - 1;
//            } else {
//                return (mid + pos) % nums.length;
//            }
//            mid = (left + right) / 2;
//        }
//
//        return -1;
//    }

    /**
     * nums分开两半，总有一半是有序的
     * 比如 [ 4 5 6 7 1 2 3] ，从 7 劈开，左边是 [ 4 5 6 7] 右边是 [ 7 1 2 3]，左边是有序的。
     * 基于这个事实。
     * 我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //左半段是有序的
            if (nums[start] <= nums[mid]) {
                //target 在这段里
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //右半段是有序的
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
        System.out.println(o.search(nums, 5));
    }
}
