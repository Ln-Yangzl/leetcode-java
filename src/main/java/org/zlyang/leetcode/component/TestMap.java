package org.zlyang.leetcode.component;

import java.util.HashMap;

/**
 * @author: zlyang
 * @date: 2022-09-03 15:22
 * @description:
 */
public class TestMap<K, V> extends HashMap<K, V> {

    public boolean test(K key){
        return this.containsKey(key);
    }

}
