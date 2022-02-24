package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-02-24 14:38
 * @description:
 */
public class SearchA2DMatrix {

    private int getInteger(int[][] matrix, int index){
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int total = matrix.length * matrix[0].length;
        int left = 0, right = total - 1;
        int mid = (left + right) / 2;
        while(left < right){
            int current = getInteger(matrix, mid);
            if(current == target){
                return true;
            } else if(current > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return getInteger(matrix, mid) == target;
    }
}
