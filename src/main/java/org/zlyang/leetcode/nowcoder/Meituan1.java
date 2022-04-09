package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-26 15:49
 * @description:
 */
public class Meituan1 {

    public static int getMaxSubNum(String str){
        int[] count = new int[3];
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'c'){
                count[str.charAt(i) - 'a']++;
            }
        }
        if(count[0] <= 1){
            return 0;
        }
        int min = Math.min(count[0] - 1, count[1]);
        return Math.min(min, count[2]/3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getMaxSubNum(str));
    }
}
