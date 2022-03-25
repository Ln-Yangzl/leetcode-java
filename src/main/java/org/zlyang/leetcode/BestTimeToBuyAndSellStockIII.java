package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-03-24 16:11
 * @description:
 */
public class BestTimeToBuyAndSellStockIII {

    private int[] getMaxProfit(int[] prices){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int money = 0;
        int[] profits = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] > max){
                int next = prices[i] - min;
                money = Math.max(money, next);
                max = prices[i];
            }
            if(prices[i] < min){
                max = Integer.MIN_VALUE;
                min = prices[i];
            }
            profits[i + 1] = money;
        }
        return profits;
    }

    private int[] getMaxReverseProfit(int[] prices){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int money = 0;
        int[] profits = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            int index = prices.length - i - 1;
            if(prices[index] > max){
                max = prices[index];
                min = Integer.MAX_VALUE;
            }
            if(prices[index] < min){
                min = prices[index];
                money = Math.max(money, max - min);
            }
            profits[i+1] = money;
        }
        return profits;
    }


    public int maxProfit(int[] prices) {
        int[] leftMaxProfits = getMaxProfit(prices);
        int[] rightMaxProfits = getMaxReverseProfit(prices);
        int maxProfit = 0;
        for (int i = 0; i <= prices.length; i++) {
            maxProfit = Math.max(maxProfit, leftMaxProfits[i] + rightMaxProfits[prices.length - i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII o = new BestTimeToBuyAndSellStockIII();
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println(o.maxProfit(nums));
    }
}
