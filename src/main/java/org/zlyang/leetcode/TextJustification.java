package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-24 9:19
 * @description:
 */
public class TextJustification {

    private String getJustifyString(List<String> current, int currentLen, int maxWidth){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(current.get(0));
        if(current.size() == 1){
            return stringBuilder
                    .append(String.join("", Collections.nCopies(maxWidth - currentLen, " ")))
                    .toString();
        }
        int widthLeft = maxWidth - currentLen;
        int spaceNums = current.size() - 1;
        int widthBetween = widthLeft / spaceNums;
        int widthPlus = widthLeft % spaceNums;
        String shortString = String.join("", Collections.nCopies(widthBetween + 1, " "));
        String longString = shortString + " ";
        for (int i = 1; i < current.size(); i++) {
            if(widthPlus > 0){
                stringBuilder.append(longString);
                widthPlus--;
            } else {
                stringBuilder.append(shortString);
            }
            stringBuilder.append(current.get(i));
        }
        return stringBuilder.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        int currentLen = words[0].length();
        current.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(currentLen + words[i].length() + 1 <= maxWidth){
                current.add(words[i]);
                currentLen += words[i].length() + 1;
            } else {
                res.add(getJustifyString(current, currentLen, maxWidth));
                current.clear();
                currentLen = words[i].length();
                current.add(words[i]);
            }
        }
        if(current.size() != 0){
            res.add(getJustifyString(current, maxWidth, maxWidth) +
                    String.join("", Collections.nCopies(maxWidth - currentLen, " ")));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification o = new TextJustification();
        System.out.println(o.fullJustify(words, 16));
    }
}
