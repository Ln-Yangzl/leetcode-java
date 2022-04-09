package org.zlyang.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-26 16:30
 * @description:
 */
public class Meituan3 {

    private static int findPareNege(ArrayList<Integer> negative, int num){
        for (int i = 0; i < negative.size() && num + negative.get(i) > 0; i++) {
            if((num + negative.get(i)) % 7 == 0){
                negative.set(i, 0);
                return negative.get(i);
            }
        }
        return 0;
    }


    public static int getMaxNum(ArrayList<Integer> positive, ArrayList<Integer> negative){
        int[] res = new int[7];
        for (Integer integer : positive) {
            res[integer % 7]++;
        }
        for (int i = 1; i <= 3; i++) {
            int min = Math.min(res[i], res[7 - i]);
            res[i] = min;
            res[7 - i] = min;
        }
        int count = 0;
        for (int i = 0; i < positive.size(); i++) {
            int index = positive.get(i) % 7;
            if(res[index] > 0){
                count += positive.get(i);
                res[index]--;
                positive.set(i, 0);
            } else {
                int neg = findPareNege(negative, positive.get(i));
                if(neg != 0){
                    count += (positive.get(i) + neg);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int nextNum = scanner.nextInt();
            if(nextNum > 0){
                positive.add(nextNum);
            } else {
                negative.add(nextNum);
            }
        }
        positive.sort(Comparator.reverseOrder());
        negative.sort(Comparator.reverseOrder());
        System.out.println(getMaxNum(positive, negative));
    }
}
