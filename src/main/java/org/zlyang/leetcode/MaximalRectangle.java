package org.zlyang.leetcode;


/**
 * @author: zlyang
 * @date: 2022-02-26 8:28
 * @description:
 */
public class MaximalRectangle {

    /**
     * 该方法超时，应利用上一题的解法，详见leetcode解析85
     */
    private boolean checkRow(char[][] matrix, int row, int start, int end){
        boolean hasZero = true;
        while(start < end){
            hasZero = hasZero && matrix[row][start] == '1';
            start++;
        }
        return hasZero;
    }

    private int getArea(char[][] matrix, int startX, int startY, int currentX, int currentY){
        int maxArea = (currentX - startX + 1) * (currentY - startY + 1);
        if(currentX + 1 < matrix.length && matrix[currentX + 1][currentY] == '1' && checkRow(matrix, currentX + 1, startY, currentY)){
            maxArea = Math.max(maxArea, getArea(matrix, startX, startY, currentX + 1, currentY));
        }
        if(currentY + 1 < matrix[0].length && matrix[currentX][currentY + 1] == '1' && currentX == startX){
            maxArea = Math.max(maxArea, getArea(matrix, startX, startY, currentX, currentY + 1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    maxArea = Math.max(maxArea, getArea(matrix, i, j, i, j));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalRectangle o = new MaximalRectangle();
        System.out.println(o.maximalRectangle(matrix));
    }
}
