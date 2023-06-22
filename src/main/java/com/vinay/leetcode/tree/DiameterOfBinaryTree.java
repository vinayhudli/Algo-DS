package com.vinay.leetcode.tree;

public class DiameterOfBinaryTree {

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

    public int diameterOfBinaryTree(TreeNode root) {
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth+rightDepth);
        return maxDiameter;
    }

    int maxDiameter = 0;
    private int maxDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        maxDiameter = Math.max(maxDiameter, left+right);
        return Math.max(left+1, right+1);
    }
}
