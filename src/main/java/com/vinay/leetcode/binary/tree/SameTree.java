package com.vinay.leetcode.binary.tree;

/*
https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (q == null && p!=null))
            return false;
        else if (p==null && q==null)
            return true;
        else if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
