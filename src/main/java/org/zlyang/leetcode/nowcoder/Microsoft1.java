package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-08-26 19:29
 * @description:
 */
public class Microsoft1 {

    public static void main(String[] args) {
        Microsoft1 microsoft1 = new Microsoft1();
        System.out.println(microsoft1.solution("zthtzh"));
    }

    public int solution(String S) {
        if(S == null || S.length() <= 1){
            return 0;
        }
        int n = S.length();
        int[] posStatus = new int[n + 1];
        int ans = 0, status = 0;
        for (int i = 1; i <= n; i++) {
            char ch = S.charAt(i - 1);
            status ^= (1 << (ch - 'a'));
            int formerPos = findFirst(posStatus, status, i);
            if (formerPos != -1) {
                ans = Math.max(ans, i - formerPos);
            }
            posStatus[i] = status;
        }
        return ans;
    }

    int findFirst(int[] posStatus, int status, int current){
        for (int i = 0; i < current; i++) {
            if (posStatus[i] == status){
                return i;
            }
        }
        return -1;
    }


}
