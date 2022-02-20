package org.zlyang.leetcode;

import java.util.Stack;

/**
 * @author: zlyang
 * @date: 2022-02-20 13:53
 * @description:
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> record = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                record.push(c);
            }
            else{
                if(record.isEmpty()){
                    return false;
                }
                Character r = record.pop();
                if(c == ')' && !r.equals('(') || c == ']' && !r.equals('[') || c == '}' && !r.equals('{')){
                    return false;
                }
            }
        }
        return record.isEmpty();
    }
}
