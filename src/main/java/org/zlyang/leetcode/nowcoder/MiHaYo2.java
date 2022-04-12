package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-10 20:28
 * @description:
 */
public class MiHaYo2 {

    public static int getOptNum(String s){
        int count = 0, current = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                current++;
            } else {
                count += current % 2;
                current = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getOptNum(s));
    }
}
