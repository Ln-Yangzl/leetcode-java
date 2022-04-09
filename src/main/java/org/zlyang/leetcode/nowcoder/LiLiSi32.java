package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:43
 * @description:
 */
public class LiLiSi32 {

    int sum = 0;

    public int getNext(int[] a, int current, int index, int left, int right){
        index = (index + a.length) % a.length;
        int currentDiff = Math.abs(sum - 2 * current);
        int nextDiff = Math.abs(sum - 2 * (current + a[index]));
        if(nextDiff >= currentDiff){
            return currentDiff;
        }
        nextDiff = Math.min(nextDiff, getNext(a, current + a[(left + a.length) % a.length], left - 1, left - 1, right));
        nextDiff = Math.min(nextDiff, getNext(a, current + a[(right + a.length) % a.length], right + 1, left, right + 1));
        return nextDiff;
    }

    public long minimum (int[] a) {
        // write code here
        int max = 0, index = -1;
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > max){
                max = a[i];
                index = i;
            }
            total += a[i];
        }
        sum = total;
        int temp =  Math.min(getNext(a, a[index] + a[(index + 1) % a.length], index + 1, index, index + 1), getNext(a, a[index] + a[(index - 1 + a.length) % a.length], index - 1, index - 1, index));
        return Math.min(temp , Math.abs(sum - 2 * total));
//        while(true){
//            int next = 0;
//            if(a[(left + a.length) % a.length] > a[(right + a.length) % a.length]){
//                next = diff - 2 * a[(right + a.length) % a.length];
//            } else {
//                next = diff - 2 * a[(left + a.length) % a.length];
//            }
//            if(Math.abs(next) > Math.abs(diff)){
//                return Math.abs(diff);
//            }
//            diff = next;
//        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LiLiSi32 o = new LiLiSi32();
        System.out.println(o.minimum(arr));
    }
}
