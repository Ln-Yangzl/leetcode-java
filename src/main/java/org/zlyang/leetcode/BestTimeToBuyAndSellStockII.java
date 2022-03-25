package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-03-24 15:55
 * @description:
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE, nextSellPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < nextSellPrice){
                profit += (nextSellPrice - buyPrice);
                buyPrice = prices[i];
                nextSellPrice = prices[i];
            } else {
                nextSellPrice = prices[i];
            }
        }
        return profit + (nextSellPrice - buyPrice);
    }
}
