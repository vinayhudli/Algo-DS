package com.vinay.leetcode.dfs;

import com.vinay.leetcode.binary.tree.PathSum2.*;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    Integer maxPath = null;

    public int maxPathSum(TreeNode root) {
        recursiveMaxPath(root);
        return maxPath;
    }

    private int recursiveMaxPath(TreeNode root){
        if (root == null)
            return -1001;
        int leftSum = recursiveMaxPath(root.left) ;
        int rightSum = recursiveMaxPath(root.right) ;
        int maxSubTreeSum = Math.max(leftSum, rightSum);
        int tempMaxSum = leftSum+rightSum+ root.val;
        tempMaxSum = Math.max(tempMaxSum, maxSubTreeSum+ root.val);
        tempMaxSum = Math.max(tempMaxSum, maxSubTreeSum);
        tempMaxSum = Math.max(tempMaxSum, root.val);
        maxPath = maxPath != null?Math.max(maxPath, tempMaxSum):tempMaxSum;
        return Math.max(maxSubTreeSum+ root.val, root.val);
    }

}
