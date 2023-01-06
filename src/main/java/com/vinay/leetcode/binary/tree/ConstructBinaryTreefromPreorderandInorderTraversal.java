package com.vinay.leetcode.binary.tree;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i=0;i<inorder.length;i++)
            inorderMap.put(inorder[i], i);

        return iterateInorderToConstructTree(preorder, inorderMap, 0, inorder.length-1);
    }

    int preorderIndex = 0;
    private TreeNode iterateInorderToConstructTree(int[] preorder, Map<Integer, Integer> inorder, int inorderStart, int inorderEnd){
        if (preorderIndex == preorder.length || inorderStart > inorderEnd)
            return null;
        int element = preorder[preorderIndex];
        int index = inorder.get(element);
        if (index<inorderStart || index>inorderEnd)
            return null;
        TreeNode treeNode = new TreeNode(element);
        preorderIndex++;
        TreeNode leftSubTree = iterateInorderToConstructTree(preorder, inorder, inorderStart, index - 1);
        if (leftSubTree == null)
            preorderIndex--;
        else
            treeNode.left = leftSubTree;
        preorderIndex++;
        TreeNode rightSubTree = iterateInorderToConstructTree(preorder, inorder, index+1, inorderEnd);
        if (rightSubTree == null)
            preorderIndex--;
        else
            treeNode.right = rightSubTree;

        return treeNode;
    }
}
