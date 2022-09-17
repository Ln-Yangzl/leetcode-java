package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-24 20:01
 * @description:
 */
public class Tencent1 {

    public static List<Integer> getRes(String[] strs){
        ArrayList<Integer> res = new ArrayList<>(strs.length);
        for (int i = 0; i < strs[0].length(); i++) {
            int current = 0;
            for (int j = 0; j < strs.length; j++) {
                current *= 10;
                current += (strs[j].charAt(i) - '0');
            }
            res.add(current);
        }
        res.sort(Integer::compareTo);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        List<Integer> res = getRes(strs);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
