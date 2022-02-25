package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/25 8:15
 */
public class Subsets {

    private int getNextIndex(List<Integer> list, int[] nums){
        if(list.isEmpty()){
            return 0;
        }
        int current = list.get(list.size() - 1);
        for (int i = 0; i < nums.length - 1; i++){
            if(current == nums[i]){
                return i + 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            while(res.get(start).size() == i){
                List<Integer> current = res.get(start);
                for (int j = getNextIndex(current, nums); j != -1 && j < nums.length; j++) {
                    ArrayList<Integer> nextList = new ArrayList<>(current);
                    nextList.add(nums[j]);
                    res.add(nextList);
                }
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets o = new Subsets();
        System.out.println(o.subsets(nums));
    }
}
