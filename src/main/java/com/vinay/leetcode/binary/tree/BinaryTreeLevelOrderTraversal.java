package com.vinay.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<>();
        List<TreeNode> currentList = Arrays.asList(root);
        List<TreeNode> childList = new ArrayList<>();
        while (!currentList.isEmpty()){
            for (TreeNode node:currentList){
                if (node.left != null) childList.add(node.left);
                if (node.right != null) childList.add(node.right);
                currentLevel.add(node.val);
            }
            result.add(currentLevel);
            currentLevel = new ArrayList<>();
            currentList = childList;
            childList = new ArrayList<>();
        }
        return result;
    }
}
