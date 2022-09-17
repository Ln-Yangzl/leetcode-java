package org.zlyang.leetcode;

import java.util.ArrayList;

/**
 * @author: zlyang
 * @date: 2022-04-14 15:18
 * @description:
 */
public class PrisonCellsAfterNDays {

    private class Node{
        int[] arr;

        boolean equal(Node node){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != node.arr[i]){
                    return false;
                }
            }
            return true;
        }

        Node(int[] arr){
            this.arr = arr.clone();
        }

        void next(){
            int former = arr[0];
            for (int i = 1; i < arr.length - 1; i++){
                int temp = arr[i];
                if(former == arr[i + 1]){
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
                former = temp;
            }
        }

    }

    private int getInt(int[] cells){
        int res = 0;
        for (int j = 0; j < cells.length; j++) {
            res *= 2;
            res += cells[j];
        }
        return res;
    }

    private int getNext(int current, int len){
        int next = 0;
        for (int i = 1; i < len - 1; i++) {
            next *= 2;
            if((current >>> (len - i) & 1) == (current >>> (len - i - 2) & 1)){
                next += 1;
            }
        }
        next = next << 1;
        return next;
    }

    private int[] getArr(int i, int len){
        int[] res = new int[len];
        for (int j = 0; j < len; j++){
            res[j] = (i >>> (len - j - 1)) & 1;
        }
        return res;
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = getInt(cells);
        list.add(start);
        int next = start;
        for (int i = 0; i < n; i++){
            next = getNext(next, cells.length);
            if(list.contains(next)){
                break;
            }
            list.add(next);
        }
        // 最后一个，没有循环
        if(list.size() == n + 1){
            return getArr(list.get(list.size() - 1), cells.length);
        }
        // 有循环的时候
        int index = list.indexOf(next);
        int repid = (n - index) % (list.size() - index);

        return getArr(list.get(index + repid - 1), cells.length);
    }

    public static void main(String[] args) {
//        [1,0,0,1,0,0,1,0]
//        1000000000

        PrisonCellsAfterNDays o = new PrisonCellsAfterNDays();
        int[] arr = {0,1,0,1,1,0,0,1};
        for (int i : o.prisonAfterNDays(arr, 7)) {
            System.out.println(i);
        }
    }
}
