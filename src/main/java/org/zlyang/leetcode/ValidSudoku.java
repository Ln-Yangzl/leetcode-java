package org.zlyang.leetcode;

import java.util.HashSet;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/22 9:57
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 使用3个长度为9的数组存储更快更省内存
        HashSet<String> record = new HashSet<String>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    String s = "(" + board[i][j] + ")";
                    if(!record.add(i + s) || !record.add(s + j) || !record.add(i / 3 + s + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
