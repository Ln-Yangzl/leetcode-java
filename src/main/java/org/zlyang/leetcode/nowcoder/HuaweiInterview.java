package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-09-16 10:18
 * @description:
 */
public class HuaweiInterview {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(getMaxProfie(arr));
    }

    public static int getMaxProfie(int[] arr){
        if (arr == null || arr.length <= 1){
            return 0;
        }

        int count = 0;
        int startPos = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= arr[i - 1]){
                continue;
            }
            count += (arr[i - 1] - arr[startPos]);
            startPos = i;
        }
        count += (arr[arr.length - 1] - arr[startPos]);
        return count;
    }

}
