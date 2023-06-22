package com.vinay.leetcode.tree;

/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
do depth first and maintain max value till the parent
 */
public class CountGoodNodesInBinaryTree {

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

    public int goodNodes(TreeNode root) {
        depthFirstTraversal(root, Integer.MIN_VALUE);
        return goodNodesCount;
    }

    int goodNodesCount = 0;
    private void depthFirstTraversal(TreeNode node, int maxValInCurrentPath){
        if (node == null)
            return;
        if (node.val >= maxValInCurrentPath){
            goodNodesCount++;
            maxValInCurrentPath = node.val;
        }
        depthFirstTraversal(node.left, maxValInCurrentPath);
        depthFirstTraversal(node.right, maxValInCurrentPath);
    }
}
