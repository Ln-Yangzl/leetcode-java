package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-24 19:26
 * @description:
 */
public class Combinations {

    private List<List<Integer>> res;

    private void backtrack(List<Integer> current, int start, int total, int limit){
        int left = total - current.size();
        if(left == 0){
            res.add(new ArrayList<Integer>(current));
        }
        for (int i = start; i < limit; i++) {
            current.add(start + 1);
            backtrack(current, start + 1, total, limit);
            current.remove(current.size() - 1);
            start++;
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, k, n);
        return res;
    }

    public static void main(String[] args) {
        Combinations o = new Combinations();
        System.out.println(o.combine(1, 1));
    }

    /**
     * 从 n 个数字选 k 个，我们把所有结果分为两种，包含第 n 个数和不包含第 n 个数。这样的话，就可以把问题转换成
     *
     *     从 n - 1 里边选 k - 1 个，然后每个结果加上 n
     *     从 n - 1 个里边直接选 k 个。
     *
     * 基于这个公式 C ( n, k ) = C ( n - 1, k - 1) + C ( n - 1, k ) 所用的思想设计递归
     * 此思路就能较为方便的使用动态规划替代
     * @param n
     * @param k
     * @return
     */
//    public List<List<Integer>> combine(int n, int k) {
//        if (k == n || k == 0) {
//            List<Integer> row = new LinkedList<>();
//            for (int i = 1; i <= k; ++i) {
//                row.add(i);
//            }
//            return new LinkedList<>(Arrays.asList(row));
//        }
//        // n - 1 里边选 k - 1 个
//        List<List<Integer>> result = combine(n - 1, k - 1);
//        //每个结果加上 n
//        result.forEach(e -> e.add(n));
//        //把 n - 1 个选 k 个的结果也加入
//        result.addAll(combine(n - 1, k));
//        return result;
//    }

}
