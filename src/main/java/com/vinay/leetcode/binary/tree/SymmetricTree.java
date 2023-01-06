package com.vinay.leetcode.binary.tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return depthFirstSearch(root.left, root.right);
    }

    private boolean depthFirstSearch(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        else if (left == null || right == null || left.val != right.val)
            return false;

        return depthFirstSearch(left.left, right.right) && depthFirstSearch(left.right, right.left);

    }

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

}
