package com.vinay.leetcode.binary.tree;

public class SumRootToLeafNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int result = 0;
    public int sumNumbers(TreeNode root) {
        calculateSum(0, root);
        return result;
    }

    private void calculateSum(int sum, TreeNode node){
        if (node == null){
            return;
        }
        sum = sum*10+node.val;
        if (node.left == null && node.right == null){
            result += sum;
            return;
        }
        calculateSum(sum, node.left);
        calculateSum(sum, node.right);
    }
}
