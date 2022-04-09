package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-04-09 17:51
 * @description:
 */
public class GasStation {

    private static class CircularArr{
        private final int[] arr;

        public CircularArr(int[] arr){
            this.arr = arr;
        }

        int getIndex(int i){
            return arr[(i + 2 * arr.length) % arr.length];
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] record = new int[gas.length];
        int sum = 0, max = Integer.MIN_VALUE, index = -1;
        for (int i = gas.length - 1; i >= 0; i--) {
            record[i] = gas[i] - cost[i];
            sum += record[i];
            if(sum > max){
                max = sum;
                index = i;
            }
        }
        if(sum < 0){
            return -1;
        }
        sum = 0;
        CircularArr circularArr = new CircularArr(record);
        for(int i = index, count = 0; count < record.length; i++, count++){
            sum += circularArr.getIndex(i);
            if(sum < 0){
                return -1;
            }
        }
        return index;
    }

    /* 更优的解法，可以不用再循环一次考虑
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        return totalSurplus < 0 ? -1 : start;
    }*/

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        GasStation o = new GasStation();
        System.out.println(o.canCompleteCircuit(gas, cost));
    }
}
