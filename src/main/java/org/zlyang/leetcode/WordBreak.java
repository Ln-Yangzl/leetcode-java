package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-04-10 8:12
 * @description:
 */
public class WordBreak {


    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        ArrayList<ArrayList<String>> record = new ArrayList<>(s.length() + 1);
        record.add(new ArrayList<>());
        record.get(0).add("");
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            ArrayList<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                String currentString = s.substring(j, i);
                boolean flag = dp[j] && dict.contains(currentString);
                dp[i] = dp[i] || flag;
                if(flag){
                    for (String formerString : record.get(j)) {
                        String addString = formerString.isEmpty() ? formerString : formerString + " ";
                        current.add(addString + currentString);
                    }
                }
            }
            record.add(current);
        }
        return record.get(s.length());
    }

    public static void main(String[] args) {
        String[] dict = {"cat","cats","and","sand","dog"};
        WordBreak o = new WordBreak();
        System.out.println(o.wordBreak("catsanddog", Arrays.asList(dict)));
    }
}
