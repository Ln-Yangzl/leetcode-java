package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-04-09 18:13
 * @description:
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        for (int i = 1; i < res.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }
        int sum = res[res.length - 1] + 1;
        for (int i = res.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
            sum += res[i] + 1;
        }
        return sum;
    }
}
