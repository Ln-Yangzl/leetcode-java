package org.zlyang.leetcode.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-02 20:17
 * @description:
 */
public class JingDong2 {

    private static int getNum(String s){
        int[] count = new int[3];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        if(count[0] == count[1] && count[1] == count[2]){
            return 0;
        }
        Arrays.sort(count);
        if(count[0] < count[1] && count[1] == count[2]){
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int len = scanner.nextInt() * 3;
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(getNum(s));
        }
    }
}
