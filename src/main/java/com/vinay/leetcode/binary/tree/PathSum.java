package com.vinay.leetcode.binary.tree;

public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return recursiveSum(root, 0, targetSum);
    }

    private boolean recursiveSum(TreeNode node, int currentSum, int targetSum){
        if (node == null)
            return false;
        int sum = currentSum + node.val;
        if (sum == targetSum && node.left == null && node.right == null)
            return true;

        return recursiveSum(node.left, sum, targetSum) || recursiveSum(node.right, sum, targetSum);
    }
}
