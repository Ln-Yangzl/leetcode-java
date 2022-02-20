package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 14:12
 * @description:
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i+1));
            if(len > end - start + 1){
                start = i - (len - 1 )/ 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();
        System.out.println(o.longestPalindrome("bb"));
    }


}
