package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-26 10:07
 * @description:
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 1; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--){
                int plus = 2 << (i - 1);
                res.add(res.get(j) + plus);
            }
        }
        return res;
    }
}
