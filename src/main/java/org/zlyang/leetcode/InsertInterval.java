package org.zlyang.leetcode;

import java.util.ArrayList;

/**
 * @author: zlyang
 * @date: 2022-02-23 14:13
 * @description:
 */
public class InsertInterval {

    /**
     * 单纯直接插入算法，更加精简
     * @param intervals
     * @param newInterval
     * @return
     */
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result = new ArrayList<Interval>();
//        for (Interval i : intervals) {
//            //新加的入的节点在当前节点后边
//            if (newInterval == null || i.end < newInterval.start)
//                result.add(i);
//                //新加入的节点在当前节点的前边
//            else if (i.start > newInterval.end) {
//                result.add(newInterval);
//                result.add(i);
//                newInterval = null;
//                //新加入的节点和当前节点有重合，更新节点
//            } else {
//                newInterval.start = Math.min(newInterval.start, i.start);
//                newInterval.end = Math.max(newInterval.end, i.end);
//            }
//        }
//        if (newInterval != null)
//            result.add(newInterval);
//        return result;
//    }


    /**
     * 使用start和end的排序数组的算法
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] res = {newInterval};
            return res;
        }
        ArrayList<int[]> res = new ArrayList<>();
        int[] starts = new int[intervals.length + 1];
        int[] ends = new int[intervals.length + 1];
        int start = 0, end = 0;
        if(newInterval[0] < intervals[0][0]){
            starts[start++] = newInterval[0];
            newInterval[0] = Integer.MIN_VALUE;
        }
        if(newInterval[1] < intervals[0][1]){
            ends[end++] = newInterval[1];
            newInterval[1] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < intervals.length; i++){
            starts[start++] = intervals[i][0];
            ends[end++] = intervals[i][1];
            if(i < intervals.length - 1 && newInterval[0] >= intervals[i][0] && newInterval[0] < intervals[i + 1][0]){
                starts[start] = newInterval[0];
                newInterval[0] = Integer.MIN_VALUE;
                start++;
            }
            if(i < intervals.length - 1 && newInterval[1] >= intervals[i][1] && newInterval[1] < intervals[i + 1][1]){
                ends[end] = newInterval[1];
                newInterval[1] = Integer.MIN_VALUE;
                end++;
            }

        }
        starts[intervals.length] = Math.max(intervals[intervals.length - 1][0], newInterval[0]);
        ends[intervals.length] = Math.max(intervals[intervals.length - 1][1], newInterval[1]);

        int startIdx = 0, endIdx = 0;
        while(endIdx < starts.length){
            if(endIdx == starts.length - 1 || starts[endIdx + 1] > ends[endIdx]){
                int[] overlapping = {starts[startIdx], ends[endIdx]};
                res.add(overlapping);
                startIdx = endIdx + 1;
            }
            endIdx++;
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,5}};
        int[] newInterval = {2,3};
        InsertInterval o = new InsertInterval();
        System.out.println(o.insert(nums, newInterval).toString());
    }
}
