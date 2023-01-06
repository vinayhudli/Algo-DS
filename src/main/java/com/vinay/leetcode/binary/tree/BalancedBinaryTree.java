package com.vinay.leetcode.binary.tree;

/**
 * here 1 thing to note that we wanted to recursively return height and also maintain if subtree is balanced or not,
 * so there is balanced variable and height is returned at each stage. This approach is required when we are trying to
 * return 2 different things
 */
public class BalancedBinaryTree {

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

    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }

    private int getHeight(TreeNode node){
        if (node == null || !balanced)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left-right) > 1)
            balanced = false;

        return Math.max(left, right)+1;
    }
}
