package org.zlyang.leetcode.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @author: zlyang
 * @date: 2022-02-22 18:46
 * @description:
 */
public class MyHeap<T extends Number> {

    private List<T> heap;

    private BiPredicate<T, T> cmp;

    public MyHeap(){
        heap = new ArrayList<>();
    }

    public MyHeap(T[] array){
        heap = Arrays.asList(array);
    }

    public MyHeap(BiPredicate<T, T> cmp){
        this.cmp = cmp;
        heap = new ArrayList<>();
    }

    public MyHeap(T[] array, BiPredicate<T, T> cmp){
        heap = Arrays.asList(array);
        this.cmp = cmp;
    }

}
