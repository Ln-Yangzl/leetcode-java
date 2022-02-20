package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 15:25
 * @description:
 */
public class StringToInteger {
    public int myAtoi(String s) {
        int res = 0, limit = Integer.MAX_VALUE / 10;
        boolean numRead = false, sign = true;
        for(char c : s.toCharArray()){
            if(c == '+' || c == '-'){
                if(numRead == true){
                    break;
                }
                sign = c == '+';
                numRead = true;
                continue;
            }
            if(!Character.isDigit(c) && numRead){
                break;
            }
            if(!Character.isDigit(c) && c != ' '){
                break;
            }
            if(res > limit){
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if(Character.isDigit(c)){
                numRead = true;
                res *= 10;
                res += c - '0';
                if(res < 0) {
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
        }
        return sign ? res : -res;
    }

    public static void main(String[] args) {
        StringToInteger o = new StringToInteger();
        System.out.println(o.myAtoi("  -42"));
    }
}
