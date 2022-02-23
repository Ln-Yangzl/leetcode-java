package org.zlyang.leetcode;

import java.util.ArrayList;

/**
 * @author: zlyang
 * @date: 2022-02-23 14:52
 * @description:
 */
public class PermutationSequence {

    static final int[] map = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    private int getFrac(int x){
        return map[x];
    }

    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            nums.add(i + 1);
        }
        k--;
        for(int i = 0; i < n; i++){
            int pos = k / getFrac(n - i - 1);
            k -= getFrac(n - i - 1) * pos;
            res.append(nums.get(pos));
            nums.remove(pos);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        PermutationSequence o = new PermutationSequence();
        System.out.println(o.getPermutation(4, 9));
    }
}
