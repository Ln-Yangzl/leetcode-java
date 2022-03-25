package org.zlyang.leetcode;

import org.zlyang.leetcode.utils.TreeNode;

/**
 * @author: zlyang
 * @date: 2022-03-25 14:05
 * @description:
 */
public class BinaryTreeMaximumPathSum {

    private int maxNum;

    private int helper(TreeNode current){
        if(current == null){
            return 0;
        }
        int leftPathNum = Math.max(0, helper(current.left));
        int rightPathNum = Math.max(0, helper(current.right));
        int next = Math.max(leftPathNum, rightPathNum) + current.val;
        maxNum = Math.max(maxNum, current.val + leftPathNum + rightPathNum);
        return next;
    }

    public int maxPathSum(TreeNode root) {
        maxNum = Integer.MIN_VALUE;
        helper(root);
        return maxNum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
        System.out.println(o.maxPathSum(treeNode));
    }
}
