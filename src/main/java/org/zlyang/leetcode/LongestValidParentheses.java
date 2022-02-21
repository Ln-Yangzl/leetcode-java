package org.zlyang.leetcode;

import java.util.Stack;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 18:22
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] match = new int[s.length()];
        Stack<Integer> record = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                record.push(i);
            } else if(!record.empty()){
                Integer front = record.pop();
                match[front] = i + 1;
                match[i] = i + 1;
            }
        }
        int maxLen = 0, current = 0;
        for (int i : match) {
            if(i != 0){
                current++;
            }else{
                maxLen = Math.max(maxLen, current);
                current = 0;
            }
        }
        return Math.max(maxLen, current);
    }

    /**
     * DP solution, much faster than using stack
     * @param args
     */
//    public int longestValidParentheses(String s) {
//        int maxans = 0;
//        int dp[] = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                //右括号前边是左括号
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                    //右括号前边是右括号，并且除去前边的合法序列的前边是左括号
//                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                }
//                maxans = Math.max(maxans, dp[i]);
//            }
//        }
//        return maxans;
//    }


    public static void main(String[] args) {
        LongestValidParentheses o = new LongestValidParentheses();
        System.out.println(o.longestValidParentheses("(()"));
    }
}
