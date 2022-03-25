package org.zlyang.leetcode;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-03-24 15:23
 * @description:
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        int current;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                current = 0;
                dp[i][j] = dp[i][j-1];
                if(s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences o = new DistinctSubsequences();
        System.out.println(o.numDistinct("rabbbit", "rabbit"));
    }
}
