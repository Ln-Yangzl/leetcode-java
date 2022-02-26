package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-26 10:32
 * @description:
 */
public class DecodeWays {

    private boolean isDecodable(char first, char second){
        return first == '1' || first == '2' && second <= '6';
    }

    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int current = 1, before = 1, next = 1;
        for (int i = 1; i < s.length(); i++){
            next = 0;
            if(isDecodable(s.charAt(i-1), s.charAt(i))){
                next += before;
            }
            if(s.charAt(i) != '0'){
                next += current;
            }
            before = current;
            current = next;
        }
        return next;
    }

    public static void main(String[] args) {
        DecodeWays o = new DecodeWays();
        System.out.println(o.numDecodings("10"));
    }
}
