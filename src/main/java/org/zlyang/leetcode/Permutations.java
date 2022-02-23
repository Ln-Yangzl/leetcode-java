package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-02-23 9:22
 * @description:
 */
public class Permutations {

    /**
     * 以下是传统递归解法
     */

    private List<List<Integer>> res;

    private void backTrack(int[] nums, List<Integer> current){
        if(nums.length == current.size()){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != Integer.MIN_VALUE){
                current.add(nums[i]);
                int temp = nums[i];
                nums[i] = Integer.MIN_VALUE;
                backTrack(nums, current);
                current.remove(current.size() - 1);
                nums[i] = temp;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        backTrack(nums, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations o = new Permutations();
        System.out.println(o.permute(nums));
    }

    /**
     * 以下是优化递归解法
     * 假设有一个函数，可以实现题目的要求，即产生 nums 的所有的组合，并且加入到 all 数组中。不过它多了一个参数，begin，即只指定从 nums [ begin ] 开始的数字，前边的数字固定不变。
     * 如果 begin 等于 nums 的长度，那么就表示 begin 前的数字都不变，也就是全部数字不变，我们只需要把它加到 all 中就行了。
     * 只需要用一个 for 循环，把每一个数字都放到 begin 一次，然后再变化后边的数字就够了，也就是调用 upset 函数，从 begin + 1 开始的所有组合。
     */
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> all = new ArrayList<>();
//        //从下标 0 开始的所有组合
//        upset(nums, 0, all);
//        return all;
//    }
//
//    private void upset(int[] nums, int begin, List<List<Integer>> all) {
//        if (begin == nums.length) {
//            ArrayList<Integer> temp = new ArrayList<Integer>();
//            for (int i = 0; i < nums.length; i++) {
//                temp.add(nums[i]);
//            }
//            all.add(new ArrayList<Integer>(temp));
//            return;
//        }
//        for (int i = begin; i < nums.length; i++) {
//            swap(nums, i, begin);
//            upset(nums, begin + 1, all);
//            swap(nums, i, begin);
//        }
//
//    }
//
//    private void swap(int[] nums, int i, int begin) {
//        int temp = nums[i];
//        nums[i] = nums[begin];
//        nums[begin] = temp;
//    }
}
