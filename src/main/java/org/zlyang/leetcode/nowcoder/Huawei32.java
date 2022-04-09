package org.zlyang.leetcode.nowcoder;

import java.util.*;

/**
 * @author: zlyang
 * @date: 2022-03-30 20:22
 * @description:
 */
public class Huawei32 {

    private static int getSon(int i){
        return 2 * (i + 1) - 1;
    }

    public static int getHigh(int tree1, int tree2, int current ,String[] nodes){
        if(tree1 >= nodes.length && tree2 >= nodes.length){
            return current + 1;
        }
        if(nodes[tree1] == null && nodes[tree2] == null){
            return current + 1;
        }
        if(nodes[tree1].equals(nodes[tree2])){
            return Math.min(getHigh(getSon(tree1), getSon(tree2) , current + 1, nodes), getHigh(getSon(tree1) + 1, getSon(tree2) + 1, current + 1, nodes));
        } else {
            return current;
        }
    }

    public static boolean isEq(int tree1, int tree2, String[] nodes){
        if(tree1 >= nodes.length && tree2 >= nodes.length){
            return true;
        }
        if(nodes[tree1].equals(nodes[tree2])){
            return isEq(getSon(tree1), getSon(tree2), nodes) && isEq(getSon(tree1) + 1, getSon(tree2) + 1, nodes);
        }
        return false;
    }

    private static int getFloor(int i){
        i = i + 1;
        int count = 0;
        while(i != 0){
            count++;
            i = i / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nodes = s.substring(1, s.length() - 1).split(",");
        if(nodes.length == 0){
            System.out.println(-1);
            return;
        }
        HashMap<String, List<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            List<Integer> list = nodeMap.getOrDefault(nodes[i], new ArrayList<>());
            list.add(i);
            nodeMap.put(nodes[i], list);
        }
        int total = getFloor(nodes.length);
        int maxHigh = -1, index = -1;
        for(int i = 1; i < nodes.length; i++){
            for(int j = i + 1; j < nodes.length; j++){
                if(isEq(i, j, nodes)){
                    i = Math.max(i, j);
                    int floor = getFloor(i);
                    if(total - floor > maxHigh && total - floor > 1){
                        maxHigh = total - floor;
                        index = i;
                    }
                }
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        if(index == -1){
            System.out.println(-1);
        }else {
            strings.add(nodes[index]);
            int i = 0, j = 0;

        }
    }
}
