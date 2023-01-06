package com.vinay.leetcode.dfs;

import com.vinay.leetcode.binary.tree.PathSum2;
import com.vinay.leetcode.binary.tree.PathSum2.*;

public class InvertBinaryTree {

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        TreeNode treeNode = pathSum2.arrayToTree(new Integer[]{});
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(null);
        pathSum2.bfsTraversal(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
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
}
