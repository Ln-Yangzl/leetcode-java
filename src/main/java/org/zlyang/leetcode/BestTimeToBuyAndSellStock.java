package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-03-24 15:45
 * @description:
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int money = 0;
        for (int price : prices) {
            if(price > max){
                int next = price - min;
                money = Math.max(money, next);
                max = price;
            }
            if(price < min){
                max = Integer.MIN_VALUE;
                min = price;
            }
        }
        return money;
    }
}
