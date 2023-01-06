package com.vinay.leetcode.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PathSum2 {

    public class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        TreeNode node = pathSum2.arrayToTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        pathSum2.bfsTraversal(node);
//        List<List<Integer>> lists = pathSum2.pathSum(node, 22);
//        for (List<Integer> list:lists){
//            System.out.println("new list");
//            for (Integer test:list){
//                System.out.println(test);
//            }
//        }
    }

    public void bfsTraversal(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node == null)
                continue;
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * bfs traversed tree array to tree
     * @param arr
     * @return
     */
    public TreeNode arrayToTree(Integer[] arr){
        if (arr.length == 0)
            return null;
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        TreeNode root= new TreeNode(arr[0]);
        treeNodes.add(root);
        int index = 0;
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.remove();
            if (index+1 > arr.length-1){
                break;
            }else {
                if (arr[index+1] != null){
                    node.left = new TreeNode(arr[index+1]);
                    treeNodes.add(node.left);
                }
            }

            if (index+2 > arr.length-1){
                break;
            }else {
                if (arr[index+2] != null){
                    node.right = new TreeNode(arr[index+2]);
                    treeNodes.add(node.right);
                }
            }
            index = index+2;
        }

        return root;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        traverse(temp, targetSum-root.val, root);
        return result;
    }

    public void traverse(List<Integer> list, int target, TreeNode node){

        if (node.left == null && node.right == null){
            if (target == 0)
                result.add(new ArrayList<>(list));
            return;
        }
        if (node.left != null) {
            list.add(node.left.val);
            traverse(list, target-node.left.val, node.left);
            list.remove(list.size()-1);
        }

        if (node.right != null){
            list.add(node.right.val);
            traverse(list, target-node.right.val, node.right);
            list.remove(list.size()-1);
        }

    }
}
