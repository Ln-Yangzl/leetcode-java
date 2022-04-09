package org.zlyang.leetcode.nowcoder;

import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-03-30 18:41
 * @description:
 */
public class Huawei1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chipNum = scanner.nextInt();
        int total = scanner.nextInt();
        scanner.nextLine();
        String[] ops = scanner.nextLine().split(" ");
        int aIndex = 0, bIndex = 0;
        int aCount = 0;
        for(int i = 0; i < ops.length - 1; i++){
            if(ops[i].equals("A")){
                if(aCount == 0 || aCount == 4){
                    aIndex = Math.max(aIndex, bIndex) + 1;
                    aCount = 0;
                }
                aCount++;
            } else {
                bIndex = Math.max(aIndex, bIndex) + 1;
            }
        }
        if(aIndex > chipNum|| bIndex > chipNum){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        if(ops[ops.length - 1].equals("A")){
            if(aCount == 0 || aCount == 4){
                aIndex = Math.max(aIndex, bIndex) + 1;
                aCount = 0;
            }
            if(aIndex > chipNum){
                System.out.println(0);
                System.out.println(0);
            } else {
                System.out.println(aIndex);
                System.out.println(aCount + 1);
            }
        } else {
            bIndex = Math.max(aIndex, bIndex) + 1;
            if(bIndex > chipNum){
                System.out.println(0);
                System.out.println(0);
            } else {
                System.out.println(bIndex);
                System.out.println(1);
            }
        }
    }
}
