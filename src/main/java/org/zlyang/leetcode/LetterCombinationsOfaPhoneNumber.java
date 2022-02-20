package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-20 10:28
 * @description:
 */
public class LetterCombinationsOfaPhoneNumber {

    private static final String[] alphabet = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" };


    /**
     * 迭代写法最优
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()){
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i)) - 2;
            while(res.peek().length() == i){
                String current = res.remove();
                for (char c : alphabet[num].toCharArray()){
                    res.add(current + c);
                }
            }
        }
        return res;
    }


    /**
     * 可使用自定义乘法，但空间耗费高
     */

//    递归写法，复杂度高
//    public List<String> letterCombinations(String digits) {
//        ArrayList<String> res = new ArrayList<>();
//        getStr(res, digits, "", 0);
//        if(res.size() == 1) {
//            res.clear();
//        }
//        return res;
//    }
//
//    private void getStr(List<String> res, String digits, String before, int pos){
//        if(pos != digits.length()){
//            for(int i = 0, k = digits.charAt(pos) - '2'; i < alphabet[k].length(); i++){
//                getStr(res, digits, before + alphabet[k].charAt(i), pos + 1);
//            }
//        } else {
//            res.add(before);
//        }
//    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber o = new LetterCombinationsOfaPhoneNumber();
        System.out.println(o.letterCombinations("23"));
    }
}
