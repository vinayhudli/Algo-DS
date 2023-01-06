package com.vinay.leetcode.binary.tree;

/*
https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeofAnotherTree {

    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return false;
        else if (isSameTree(root, subRoot))
                return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if ((root == null && subRoot != null) || (root!= null && subRoot == null))
            return false;
        else if (root == null)
            return true;
        else if (root.val == subRoot.val)
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        return false;
    }


}
