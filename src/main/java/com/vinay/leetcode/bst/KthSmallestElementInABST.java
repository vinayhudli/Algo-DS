package com.vinay.leetcode.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class KthSmallestElementInABST {

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

    public static void main(String[] args) {
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        TreeNode treeNode = kthSmallestElementInABST.arrayToTree(new Integer[]{3,1,4,null,2});
        System.out.println(kthSmallestElementInABST.kthSmallest(treeNode, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        currentNum = k;
        inOrderTraversal(root);
        return kthSmallestNum;
    }

    Integer kthSmallestNum = null ;
    int currentNum ;
    public void inOrderTraversal(TreeNode node){
        if (node == null)
            return ;

        inOrderTraversal(node.left);
        currentNum--;
        if (currentNum == 0) {
            if (kthSmallestNum == null)
                kthSmallestNum = node.val;
            return;
        }
        inOrderTraversal(node.right);
    }

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
}
