package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-09-16 11:27
 * @description:
 */
public class HuaweiInteview {

    private static final String[] NUM_TO_CHAR = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String num = "3";
        System.out.println(getStrings(num));
    }


    public static List<String> getStrings(String num){
        if(num == null || num.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<String> startStr = new ArrayList<>();
        int pos = num.charAt(0) - '2';
        String charToAdd = NUM_TO_CHAR[pos];
        for (int i = 0; i < charToAdd.length(); i++) {
            startStr.add(String.valueOf(charToAdd.charAt(i)));
        }
        return getStringInner(startStr, num.substring(1));
    }

    private static List<String> getStringInner(List<String> strs, String nums){
        if(nums == null || nums.isEmpty()){
            return strs;
        }
        ArrayList<String> next = new ArrayList<>();
        int num = nums.charAt(0) - '2';
        String charToAdd = NUM_TO_CHAR[num];
        for (int i = 0; i < charToAdd.length(); i++){
            for (String str : strs) {
                next.add(str + charToAdd.charAt(i));
            }
        }
        return getStringInner(next, nums.substring(1));
    }

}
