package org.zlyang.leetcode;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-04-12 9:31
 * @description:
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[] dp = new int[dungeon[0].length];
        dp[dp.length - 1] = Math.max(1, -dungeon[dungeon.length - 1][dungeon[0].length - 1] + 1);
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i] = Math.max(1, dp[i + 1] - dungeon[dungeon.length - 1][i]);
        }

        for(int i = dungeon.length - 2; i >= 0; i--){
            int before = dp[dp.length - 1];
            dp[dp.length - 1] = Math.max(1, dp[dp.length - 1] - dungeon[i][dp.length - 1]);
            for (int j = dp.length - 2; j >=0; j--){
                int bottom = Math.max(1, dp[j] - dungeon[i][j]);
                int right = Math.max(1, dp[j + 1] - dungeon[i][j]);
                dp[j] = Math.min(bottom, right);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] board = {{0, -3}};
        DungeonGame o = new DungeonGame();
        System.out.println(o.calculateMinimumHP(board));
    }
}
