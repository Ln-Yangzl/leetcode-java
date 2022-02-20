package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-20 9:28
 * @description:
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1 || "".equals(strs[0])){
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        for(int current = res.length(); current < strs[0].length(); current++) {

            char c = strs[0].charAt(current);
            for (String s : strs) {
                if (s.length() == current || s.charAt(current) != c) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix o = new LongestCommonPrefix();
        System.out.println(o.longestCommonPrefix(strs));
    }
}
