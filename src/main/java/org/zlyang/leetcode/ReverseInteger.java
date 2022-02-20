package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 15:14
 * @description:
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean sign = x > 0;
        int limit = Integer.MIN_VALUE / 10;
        x = x < 0 ? x : -x;
        int res = 0;
        while(x != 0){
            if(res < limit){
                return 0;
            }
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return sign ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE / 10);
    }
}
