package org.zlyang.leetcode;

import java.util.ArrayList;

/**
 * @author: zlyang
 * @date: 2022-02-26 14:35
 * @description:
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for (int i = 2; i <= n; i++) {
            int next = 0;
            for (int j = 0; j <= (i - 1) / 2; j++) {
                next += dp.get(j) * dp.get(i - j - 1) * (j == i - j - 1 ? 1 : 2);
            }
            dp.add(next);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees o = new UniqueBinarySearchTrees();
        System.out.println(o.numTrees(3));
    }
}
