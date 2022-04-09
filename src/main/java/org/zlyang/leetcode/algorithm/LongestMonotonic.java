package org.zlyang.leetcode.algorithm;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-04-01 9:49
 * @description:
 */
public class LongestMonotonic {

    private int getInsertionIndex(int i){
        if(i < 0){
            return - i - 1;
        }
        return i;
    }

    public int[] getLongestMonotonic(int[] arr){
        int[] record = new int[arr.length];
        int index = 0;
        for (int i : arr) {
            int insertionIndex = getInsertionIndex(Arrays.binarySearch(arr, 0, index + 1, i));
            record[insertionIndex] = i;
            index = Math.max(insertionIndex, index);
        }
        return Arrays.copyOf(record, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1};
        LongestMonotonic o = new LongestMonotonic();
        for (int i : o.getLongestMonotonic(arr)) {
            System.out.println(i);
        }
    }
}
