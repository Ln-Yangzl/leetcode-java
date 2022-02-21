package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/21 14:14
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int totalStringHash = 0, totalWordsHash = 0;
        int wordLen = words[0].length();
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        int totalLen = words.length * wordLen;
        if(s.length() < totalLen) {
            return res;
        }
        // 初始化words的hash和
        for(int i = 0; i < words.length; i++){
            int sum = 0;
            for (char c : words[i].toCharArray()){
                sum += c;
            }
            wordsMap.computeIfPresent(words[i], (k, v) -> v + 1);
            wordsMap.computeIfAbsent(words[i], k -> 1);
            totalWordsHash += sum;
        }
        // 初始化字符串s的初始前几位的hash和
        int pos = 0;
        for(int i = 0; i < words.length; i++){
            int sum = 0;
            for(int j = 0; j < words[i].length(); j++, pos++){
                sum += s.charAt(pos);
            }
            totalStringHash += sum;
        }

        for(int i = 0; i + totalLen < s.length() + 1; i++){
            if(totalStringHash == totalWordsHash){
                HashMap<String, Integer> currentMap = new HashMap<>();
                int count = 0;
                for(int j = 0; j < words.length; j++){
//                    int index = 0;
//                    for(index = 0; index < words.length; index++){
//                        String substring = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
//                        if(!indexUsed.contains(index) && words[index].equals(s.substring(i + j * wordLen, i + (j + 1) * wordLen))){
//                            indexUsed.add(index);
//                            break;
//                        }
                    String substring = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                    if(wordsMap.containsKey(substring)){
                        currentMap.computeIfPresent(substring, (k, v) -> v + 1);
                        currentMap.computeIfAbsent(substring, k -> 1);
                        if(wordsMap.get(substring) < currentMap.get(substring)){
                            break;
                        }
                    } else {
                        break;
                    }
//                    }
                    // 未找到相等子串，直接结束该次循环
//                    if(index == words.length){
//                        break;
//                    }
                    count++;
                }
                // 检查是否所有子串都被成功匹配
                if(count == words.length){
                    res.add(i);
                }
            }
            if(i + totalLen < s.length()){
                totalStringHash += (s.charAt(i + totalLen) - s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        SubstringWithConcatenationOfAllWords o = new SubstringWithConcatenationOfAllWords();
        System.out.println(o.findSubstring(s, words));
    }

}
