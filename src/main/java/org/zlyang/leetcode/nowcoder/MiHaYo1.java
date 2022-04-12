package org.zlyang.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-10 20:15
 * @description:
 */
public class MiHaYo1 {

    public static int getScore(String s){
        LinkedList<Character> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case ')':
                    if(!stack.isEmpty() && stack.getFirst().equals('(')){
                        count += 1;
                        stack.pop();
                    } else {
                        stack.clear();
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.getFirst().equals('[')){
                        count += 2;
                        stack.pop();
                    } else {
                        stack.clear();
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.getFirst().equals('{')){
                        count += 3;
                        stack.pop();
                    } else {
                        stack.clear();
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getScore(s));
    }
}
