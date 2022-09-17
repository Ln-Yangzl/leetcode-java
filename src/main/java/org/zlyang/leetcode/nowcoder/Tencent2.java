package org.zlyang.leetcode.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-04-24 20:07
 * @description:
 */
public class Tencent2 {

    private Set<Integer> specail = new HashSet<>();

    private Set<Integer> nomal = new HashSet<>();

    private boolean isDelete(int i){
        if(i == 1){
            return true;
        }

        if(specail.contains(i)){
            return false;
        }

        if(nomal.contains(i)){
            return true;
        }

        for (int j = 2; j <= i / 2; j++) {
            if(i % j == 0){
                nomal.add(i);
                return true;
            }
        }
        specail.add(i);
        return false;
    }

    public int getNumber (int[] a) {
        // write code here
        int currentLen = a.length;
        while(currentLen > 1){
            int front = 0, back = 0;
            while(back < currentLen){
                if(isDelete(back + 1)){
                    back++;
                } else {
                    a[front++] = a[back++];
                }
            }
            currentLen = front;
        }
        return a[0];
    }

    public static void main(String[] args) {
        Tencent2 tencent2 = new Tencent2();
        int[] arr = {1,2,3,4};
        System.out.println(tencent2.getNumber(arr));
    }
}
