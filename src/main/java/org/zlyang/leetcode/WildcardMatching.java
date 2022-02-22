package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-22 16:10
 * @description:
 */
public class WildcardMatching {
    /**
     * 此迭代方法效率更高
     * @param str
     * @param pattern
     * @return
     */
//    boolean isMatch(String str, String pattern) {
//        int s = 0, p = 0, match = 0, starIdx = -1;
//        //遍历整个字符串
//        while (s < str.length()){
//            // 一对一匹配，两指针同时后移。
//            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
//                s++;
//                p++;
//            }
//            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
//            else if (p < pattern.length() && pattern.charAt(p) == '*'){
//                starIdx = p;
//                match = s;
//                p++;
//            }
//            // 当前字符不匹配，并且也没有 *，回退
//            // p 回到 * 的下一个位置
//            // match 更新到下一个位置
//            // s 回到更新后的 match
//            // 这步代表用 * 匹配了一个字符
//            else if (starIdx != -1){
//                p = starIdx + 1;
//                match++;
//                s = match;
//            }
//            //字符不匹配，也没有 *，返回 false
//            else return false;
//        }
//
//        //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
//        while (p < pattern.length() && pattern.charAt(p) == '*')
//            p++;
//
//        return p == pattern.length();
//    }



    /**
     * this DP solution is too slow
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0){
            return true;
        }
        if(s.length() != 0 && p.length() == 0){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp[0].length; i++){
            if(p.charAt(i - 1) != '*'){
                break;
            }
            dp[0][i] = true;
        }
        boolean[] record = new boolean[p.length() + 1];
        record[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j - 1) == '*'){
                    for(int k = j; k < dp[i].length; k++){
                        dp[i][j] = record[j-1];
                    }
                }
                record[j] = record[j] || dp[i][j];
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildcardMatching o = new WildcardMatching();
        System.out.println(o.isMatch("acdcb", "a*c?b"));
//        System.out.println(o.isMatch("adceb", "*a*b"));
//        System.out.println(o.isMatch("aab", "c*a*b"));
//        System.out.println(o.isMatch("aa", "*"));
    }
}
