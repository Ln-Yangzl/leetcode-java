package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-02-23 9:48
 * @description:
 */
public class PermutationsII {

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void backTrack(int[] nums, int pos, List<List<Integer>> res){
        if(pos == nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i = pos; i < nums.length; i++){
            if(used.add(nums[i])){
                swap(nums, i, pos);
                backTrack(nums, pos + 1, res);
                swap(nums, i, pos);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermutationsII o = new PermutationsII();
        System.out.println(o.permuteUnique(nums));
    }
}
