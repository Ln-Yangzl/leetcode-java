package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 10:44
 * @description:
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length;
        int leftTotal = (nums1.length + nums2.length + 1) / 2;
        while(left < right){
            // nums1分界
            int i = (left + right + 1) / 2;
            // nums2分界
            int j = leftTotal - i;
            int leftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int rightMin = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
            if(leftMax < rightMin) {
                left = i;
            } else {
                right = i - 1;
            }
        }
        int i = (left + right + 1) / 2, j = leftTotal - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
        int nums1RightMin = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
        if((nums1.length + nums2.length) % 2 == 0){
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
}
