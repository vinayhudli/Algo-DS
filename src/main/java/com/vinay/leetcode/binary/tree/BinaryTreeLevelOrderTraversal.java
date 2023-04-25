package com.vinay.leetcode.binary.tree;

import java.util.*;

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

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((insert, present)->present-insert);
        queue.add(10);
        queue.add(5);
        queue.add(15);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
