package com.vinay.leetcode.binary.tree;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        depthFirstTraversal(root, 0);
        return maxDepth;
    }
    int maxDepth = 0;

    private void depthFirstTraversal(TreeNode node, int depth){
        if (node == null) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }
        depth++;
        depthFirstTraversal(node.left, depth);
        depthFirstTraversal(node.right, depth);
    }

    public static void main(String[] args) {

    }
}


//  Definition for a binary tree node.
  class TreeNode {
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

