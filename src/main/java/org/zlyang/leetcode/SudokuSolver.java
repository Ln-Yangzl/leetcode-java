package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/22 10:20
 */
public class SudokuSolver {

    private static final int LEN = 9;

    private int[] rows = new int[9];

    private int[] cols = new int[9];

    private int[] blocks = new int[9];

    private char[][] board;
    /**
     * 在i,j处填入一个数字，同时更新所在行、列、块的剩余可能性
     * 当某处可能性唯一时，填入该数字继续更新
     * @param row
     * @param col
     * @param val
     */
    private void update(int row, int col, int val){
        // 0-9的出现存储在1个int中，为1是已存在，0是尚未存在
        int target = (int)Math.pow(10, val);
        rows[row] += target;
        cols[col] += target;
        blocks[(row + col) / 3] += target;
        int nextUpdate = checkValid(row, 0);
        if(nextUpdate != -1){
            //TODO: 继续完成Sudoku Solver
        }
    }

    /**
     * 查找是否可能性唯一（只剩一个数字可填）
     * @param pos
     * @param type 0-row, 1-col, 2-val
     * @return
     */
    private int checkValid(int pos, int type){
        int[] target;
        switch (type){
            case 0:
                target = this.rows;
                break;
            case 1:
                target = this.cols;
                break;
            case 2:
                target = this.blocks;
                break;
            default:
                target = new int[0];
                break;
        }
        int temp = target[pos], valid = -1;
        for(int i = 0; i < LEN; i++){
            if(temp % 10 == 0){
                if(valid != -1){
                    break;
                }
                valid = i;
            }
            temp /= 10;
        }
        return valid;
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
    }
}
