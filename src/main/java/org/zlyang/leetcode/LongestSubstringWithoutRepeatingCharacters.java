package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-19 10:09
 * @description:
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for(int i = 0, j = 0; i < s.length(); i++){
            j = cache[s.charAt(i)] > 0 ? Math.max(j, cache[s.charAt(i)]) : j;
            // 此处存储i+1而非i是为了将0表示不存在而非存在于位置0
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = new String(" ");
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(o.lengthOfLongestSubstring(s));
    }
}
