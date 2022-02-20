package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-20 9:19
 * @description:
 */
public class RomanToInteger {

    private static final char[] sym = {'M','D','C','L','X','V','I'};

    private static final int[] val = {1000, 500, 100, 50, 10, 5, 1 ,0, 0};

    private static final int NUM_TOTAL = 7;

    public int romanToInt(String s) {
        int res = 0, current = 0, before = 0;
        for (char c : s.toCharArray()){
            current = 0;
            while(sym[current] != c){
                current++;
            }
            if(current < before){
                res += (val[current] - 2*val[before]);
            } else {
                res += val[current];
            }
            before = current;
        }
        return res;
    }
}
