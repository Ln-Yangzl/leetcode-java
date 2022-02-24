package org.zlyang.leetcode;

import java.util.Arrays;

/**
 * @author: zlyang
 * @date: 2022-02-24 10:13
 * @description:
 */
public class EditDistance {

//    private int distance = Integer.MAX_VALUE;
//
//    private void backtrack(StringBuilder word, String target, int wordPos, int targetPos, int count){
//        if(targetPos == target.length()){
//            distance = Math.min(distance, count + word.length() - target.length());
//            return;
//        }
//        // insert new char
//        if(count < distance){
//            word.insert(wordPos, target.charAt(targetPos));
//            backtrack(word, target, wordPos + 1, targetPos + 1, count + 1);
//            word.deleteCharAt(wordPos);
//        }
//        if(word.length() == wordPos || count > distance){
//            return;
//        }
//        // char equal
//        if(word.charAt(wordPos) == target.charAt(targetPos)){
//            backtrack(word, target, wordPos + 1, targetPos + 1, count);
//        }
//        // delete char
//        if(word.length() != 0 && word.length() >= target.length()){
//            char temp = word.charAt(wordPos);
//            word.deleteCharAt(wordPos);
//            backtrack(word, target, wordPos, targetPos, count + 1);
//            word.insert(wordPos, temp);
//        }
//        // replace char
//        char temp = word.charAt(wordPos);
//        word.setCharAt(wordPos, target.charAt(targetPos));
//        backtrack(word, target, wordPos + 1, targetPos + 1, count + 1);
//        word.setCharAt(wordPos, temp);
//    }
//
//    public int minDistance(String word1, String word2) {
//        distance = Math.max(0, word1.length() - word2.length()) + word2.length();
//        backtrack(new StringBuilder(word1), word2, 0, 0, 0);
//        return distance;
//    }

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            int before = dp[0];
            dp[0] = i + 1;
            for(int j = 0; j < word2.length(); j++){
                int next = Math.min(dp[j + 1], dp[j]) + 1;
                if(word1.charAt(i) == word2.charAt(j)){
                    next = Math.min(next, before);
                } else {
                    next = Math.min(next ,before + 1);
                }
                before = dp[j + 1];
                dp[j + 1] = next;
            }
        }
        return dp[word2.length()];
    }


    public static void main(String[] args) {
        EditDistance o = new EditDistance();
        System.out.println(o.minDistance("intention", "execution"));
    }
}
