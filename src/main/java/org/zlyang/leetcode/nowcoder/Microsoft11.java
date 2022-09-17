package org.zlyang.leetcode.nowcoder;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-08-26 21:16
 * @description:
 */
public class Microsoft11 {

    public int solution(String S) {
        if (S == null || S.length() <= 1) {
            return 0;
        }
        int len = S.length();
        HashMap<Integer, Integer> statusMap = new HashMap<>();
        int ans = 0, status = 0;
        statusMap.put(0, 0);
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            status ^= (1 << (ch - 'a'));
            if(statusMap.containsKey(status)){
                Integer pos = statusMap.get(status);
                ans = Math.max(ans, i + 1 - pos);
            } else {
                statusMap.put(status, i + 1);
            }
        }
        return ans;
    }

}
