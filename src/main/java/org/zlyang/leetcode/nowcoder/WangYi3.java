package org.zlyang.leetcode.nowcoder;

import org.zlyang.leetcode.SurroundedRegions;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-16 15:35
 * @description:
 */
public class WangYi3 {

    private static class UnionSet{
        private final int[] set;

        public UnionSet(int n){
            this.set = new int[n];
            for (int i = 0; i < n; i++) {
                this.set[i] = i;
            }
        }

        public int find(int index){
            int temp = index;
            while(set[index] != index){
                index = set[index];
            }
            set[temp] = index;
            return index;
        }

        public void join(int x, int y){
            x = find(x);
            y = find(y);
            if (x < y){
                set[y] = x;
            } else {
                set[x] = y;
            }
        }

        public boolean isSame(int x, int y){
            return find(x) == find(y);
        }

        public int getIndex(){
            for (int i = 0; i < set.length; i++) {
                if(set[i] != 0){
                    return i;
                }
            }
            return 0;
        }

    }

    private static class Point{
        int x;
        int y;
        long wight;

        Point(int x, int y, long wight){
            this.x = x;
            this.y = y;
            this.wight = wight;
        }
    }

    private static long getWight(long value1, long value2){
        BigInteger bigInteger = new BigInteger(String.valueOf(value1));
        String str = bigInteger.multiply(new BigInteger(String.valueOf(value2))).toString();
        long count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == '0'){
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static long getValue(long[][] wight, boolean[][] hasEdges, UnionSet unionSet){
        long res = 0;
        int next;
        while((next = unionSet.getIndex()) != 0){
            int minTarget = -1;
            long minWight = Long.MAX_VALUE;
            for (int i = 0; i < hasEdges.length; i++) {
                if(hasEdges[i][next] && wight[i][next] != 0 && minWight > wight[i][next] && unionSet.find(i) == 0){
                    minTarget = i;
                    minWight = wight[i][next];
                }
                unionSet.join(0, next);
                hasEdges[minTarget][next] = hasEdges[next][minTarget] = false;
                res += minWight;
            }
        }
        return res;
    }

    public static long getRes(PriorityQueue<Point> wightSet, UnionSet unionSet){
        long res = 0;
        while(!wightSet.isEmpty()){
            Point point = wightSet.poll();
            if(!unionSet.isSame(point.x, point.y)){
                res += point.wight;
                unionSet.join(point.x, point.y);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        int edges = scanner.nextInt();
        long[] values = new long[edges];
        for (int i = 0; i < edges; i++) {
            values[i] = scanner.nextLong();
        }
        long[][] wight = new long[point][point];
        boolean[][] hasEdges = new boolean[point][point];
        long total = 0;
        UnionSet unionSet = new UnionSet(point);
        PriorityQueue<Point> wightSet = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.wight > o2.wight){
                    return 1;
                }else if (o1.wight < o2.wight){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < edges; i++) {
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt() - 1;
            long w = getWight(values[left], values[right]);
            wight[left][right] = wight[right][left] = w;
            total += w;
            hasEdges[left][right] = hasEdges[right][left] = true;
            if(w == 0){
                unionSet.join(left, right);
            } else {
                wightSet.add(new Point(left, right, w));
            }
        }
        System.out.println(total - getRes(wightSet, unionSet));
    }
}
