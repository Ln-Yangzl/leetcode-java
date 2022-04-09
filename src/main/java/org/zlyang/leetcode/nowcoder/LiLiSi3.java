package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:32
 * @description:
 */
public class LiLiSi3 {
    public long minimum (int[] a) {
        // write code here
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        int left = 0, right = a.length - 1;
        int diff = total;
        while(left < right){
            int leftChange = diff - 2 * a[left];
            int rightChange = diff - 2 * a[right];
            int next = 0;
            if(Math.abs(leftChange) < Math.abs(rightChange)){
                left++;
                next = leftChange;
            } else {
                right--;
                next = rightChange;
            }
            if(Math.abs(next) > Math.abs(diff)){
                return Math.abs(diff);
            }
            diff = next;
        }
        return Math.abs(diff);
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 6, 4, 2, 1};
        LiLiSi3 o = new LiLiSi3();
        long minimum = o.minimum(arr);
        System.out.println(minimum);
    }
}
