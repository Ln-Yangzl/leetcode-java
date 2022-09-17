package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-08-26 20:26
 * @description:
 */
public class Microsoft3 {

    public static void main(String[] args) {
        Microsoft3 microsoft3 = new Microsoft3();
        System.out.println(microsoft3.solution(new int[]{1,2,4,3}, new int[]{1,3,2,3}));
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        boolean[] isPresent = new boolean[100000 + 1];
        for (int i = 0; i < A.length; i++) {
            int a = A[i], b = B[i];
            isPresent[Math.max(a, b)] = true;
        }
        for (int i = 1; i < isPresent.length; i++) {
            if(!isPresent[i]){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

}
