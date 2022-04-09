package org.zlyang.leetcode.nowcoder;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-04-01 19:58
 * @description:
 */
public class LiLiSi34 {


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
        int count = 0;
        for (int i = 0; i <= index; i++) {
            count += a[i];
        }
        int min = Math.abs(total - 2 * count);
        for(int i = 0; i < index; i++){
            if(i != 0){
                count -= a[i];
                int next = Math.abs(total - 2 * count);
                if(next > min){
                    break;
                }
                min = next;
            }
            int temp = count;
            for (int j = index + 1; j < a.length; j++) {
                temp += a[j];
                int next = Math.abs(total - 2 * temp);
                if(next > min){
                    break;
                }
                min = next;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        LiLiSi34 o = new LiLiSi34();
        System.out.println(o.minimum(a));
    }
}
