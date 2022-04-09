package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:53
 * @description:
 */
public class LiLiSi33 {
    public long minimum (int[] a) {
        int min = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = i + 1; j < a.length; j++) {
                count += a[j];
                int diff = Math.abs(total - 2 * count);
                min = Math.min(min, diff);
            }
        }
        return min;
    }
}
