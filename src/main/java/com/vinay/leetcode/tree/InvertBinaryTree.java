package com.vinay.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/problems/invert-binary-tree/
Description: Either use BFS or just top down recursion to avoid extra space
 */
public class InvertBinaryTree {
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

    /*
    BFS and invert the child
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            TreeNode temp = remove.left;
            remove.left = remove.right;
            remove.right = temp;
            if (remove.left != null) queue.add(remove.left);
            if (remove.right != null) queue.add(remove.right);
        }
        return root;
    }

    /*
    Description: traversing top down and inverting child at each level, doesn't store the child in queue like in the above method
     */
    public TreeNode invertTreeBetter(TreeNode root) {
        swapChildrenNodes(root);
        return root;
    }

    private void swapChildrenNodes(TreeNode node){
        if (node == null)
            return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        swapChildrenNodes(node.left);
        swapChildrenNodes(node.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(null);
    }
}
