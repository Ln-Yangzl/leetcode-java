package org.zlyang.leetcode.nowcoder;

import java.util.*;

/**
 * @author: zlyang
 * @date: 2022-09-10 16:17
 * @description:
 */
public class MeiTuan03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        Map<Integer, Integer> valueMap = new HashMap<>();
        ArrayList<Integer> posRecord = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            int pos = scanner.nextInt();
            posRecord.add(pos);
        }
        int maxPos = posRecord.get(posRecord.size() - 1);
        for (int i = 0; i < total; i++) {
            int value = scanner.nextInt();
            Integer currentValue = valueMap.getOrDefault(posRecord.get(i), 0);
            valueMap.put(posRecord.get(i), value + currentValue);
        }

        Set<Integer> keys = valueMap.keySet();
        ArrayList<Integer> posToCheck = new ArrayList<>(keys);
        Collections.sort(posToCheck, (a, b) -> b - a);
        long maxValue = 0;
        for (int i = 0; i < posToCheck.size(); i++) {
            int currentPos = posToCheck.get(i);
            long current = valueMap.getOrDefault(currentPos, 0);
            while(currentPos >= 1){
                currentPos /= 2;
                current += valueMap.getOrDefault(currentPos, 0);
            }
            maxValue = Math.max(current, maxValue);
        }
        System.out.println(maxValue);
    }

}
