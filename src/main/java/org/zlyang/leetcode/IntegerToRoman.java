package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-20 9:10
 * @description:
 */
public class IntegerToRoman {

    private static final String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static final int NUM_TOTAL = 13;

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; num != 0 && i < NUM_TOTAL; i++){
            while(num >= val[i]){
                num -= val[i];
                res.append(sym[i]);
            }
        }
        return res.toString();
    }
}
