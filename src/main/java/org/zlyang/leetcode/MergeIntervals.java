package org.zlyang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zlyang
 * @date: 2022-02-23 10:44
 * @description:
 */
public class MergeIntervals {
    /**
     * 将所有端点排序后逐步遍历，这样更快
     * @param intervals
     * @return
     */
//    public int[][] merge(int[][] intervals) {
//        if(intervals.length <= 1){
//            return intervals;
//        }
//
//        int[] start = new int[intervals.length];
//        int[] end = new int[intervals.length];
//
//        for(int i = 0; i < intervals.length; i++){
//            start[i] = intervals[i][0];
//            end[i] = intervals[i][1];
//        }
//
//        Arrays.sort(start);
//        Arrays.sort(end);
//
//        int startIdx = 0;
//        int endIdx = 0;
//        List<int[]> ans = new ArrayList<>();
//
//        while(endIdx < intervals.length){
//            if(endIdx == intervals.length - 1 || start[endIdx + 1] > end[endIdx]){
//                int[] overlapping = {start[startIdx], end[endIdx]};
//                ans.add(overlapping);
//                startIdx = endIdx + 1;
//            }
//            endIdx++;
//        }
//
//        return ans.toArray(new int[ans.size()][]);
//    }

    /**
     * 将区间排序后进行遍历
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= start && intervals[i][0] <= end ){
                end = Math.max(intervals[i][1], end);
            }
            else{
                int[] ints = new int[2];
                ints[0] = start;
                ints[1] = end;
                res.add(ints);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] ints = new int[2];
        ints[0] = start;
        ints[1] = end;
        res.add(ints);
        return res.toArray(new int[0][0]);
    }
}
