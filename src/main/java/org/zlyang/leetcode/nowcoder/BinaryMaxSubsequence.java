package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：zlyang
 * @description：https://blog.csdn.net/xyjy11/article/details/118032689
 * @date ：2022/2/28 14:47
 */

//小强现在有n个物品,每个物品有x,y两种属性和.他想要从中挑出尽可能多的物品满足以下条件:对于任意两个物品 i 和 j ,满足（ i.x < j.x 且 i.y < j.y）或者（i.x > j.x 且 i.y > j.y）.问最多能挑出多少物品
//
//        第一行输入一个正整数 T.表示有T组数据.
//        对于每组数据,第一行输入一个正整数N.表示物品个数N.
//        接下来两行,每行有个N整数.
//        第一行表示N个节点的X属性.
//        第二行表示N个节点的Y属性


public class BinaryMaxSubsequence {

    private class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(x != o.x){
                return x - o.x;
            } else {
                return o.y - y;
            }
        }
    }

    private int binarySearch(int[] nums, int end, int key){
        int start = 0, mid = (start + end) / 2;
        while(start < end){
            if(nums[mid] == key){
                return mid;
            }
            else if(nums[mid] > key){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return mid;
//        while(end > 0){
//            if(nums[end - 1] < key && nums[end] >= key){
//                return end;
//            }
//            end--;
//        }
//        return end;
    }

    private int getMaxNumOfGoods(int[] xNums, int[] yNums){
        ArrayList<Point> points = new ArrayList<>(xNums.length);
        for (int i = 0; i < xNums.length; i++) {
            points.add(new Point(xNums[i], yNums[i]));
        }
        points.sort(Point::compareTo);
        int[] record = new int[xNums.length];
        int currentLen = 1;
        record[0] = points.get(0).y;
        for (int i = 1; i < yNums.length; i++) {
            if(points.get(i).y > record[currentLen - 1]){
                record[currentLen] = points.get(i).y;
                currentLen++;
            } else {
                int pos = this.binarySearch(record, currentLen - 1, points.get(i).y);
                // 此时不需要更新currentLen
                // 也不需要担心序列顺序问题，因为新序列包含在了record中，当其变长时会自动超过maxLen
                // 以序列5,8,1,2,3为例可以明白
                record[pos] = points.get(i).y;
            }
        }
        return currentLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        BinaryMaxSubsequence o = new BinaryMaxSubsequence();
        for (int i = 0; i < nums; i++) {
            int len = scanner.nextInt();
            int[] xNums = new int[len];
            int[] yNums = new int[len];
            for (int j = 0; j < len; j++) {
                xNums[j] = scanner.nextInt();
            }
            for (int j = 0; j < len; j++) {
                yNums[j] = scanner.nextInt();
            }
            System.out.println(o.getMaxNumOfGoods(xNums, yNums));
        }
    }
}
