package com.vinay.leetcode.bst;

public class ConvertSortedArrayToBinarySearchTree {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = constructChildNode(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode constructChildNode(int[] nums, int start, int end){
        if (start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructChildNode(nums, start, mid-1);
        node.right = constructChildNode(nums, mid+1, end);
        return node;
    }
}
