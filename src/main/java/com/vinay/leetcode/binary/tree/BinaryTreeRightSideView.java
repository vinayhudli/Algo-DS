package com.vinay.leetcode.binary.tree;

import java.util.*;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> levelNode = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode rightNode = null;
            while (!queue.isEmpty()){
                rightNode = queue.remove();
                if (rightNode.left != null)
                    levelNode.add(rightNode.left);
                if (rightNode.right != null)
                    levelNode.add(rightNode.right);
            }
            queue = levelNode;
            levelNode = new ArrayDeque<>();
            result.add(rightNode.val);
        }
        return result;
    }

    //    This is really clever solution , maintaining the level and the list size and just only considering the rightmost elements
    public List<Integer> rightSideViewImproved(TreeNode root) {
        ArrayList<Integer>list = new ArrayList<>();
        rightView(root , 0 , list);
        return list;
    }
    public void rightView(TreeNode root , int level , ArrayList<Integer>list){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        rightView(root.right , level + 1 , list);
        rightView(root.left , level + 1 , list);
    }

}
