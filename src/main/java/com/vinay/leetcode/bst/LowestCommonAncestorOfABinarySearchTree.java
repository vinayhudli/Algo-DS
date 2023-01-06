package com.vinay.leetcode.bst;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinarySearchTree {

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

    }
    Set<TreeNode> parentOfp = new HashSet<>();
    TreeNode commonAncestor ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root.val == p.val || root.val == q.val || (root.val-p.val)*(root.val-q.val)<0)
//            return root;
//        trackAllParentsOfNode(root, p, true);
//        trackAllParentsOfNode(root, q, false);
//        return commonAncestor;

        /**
         * this solution is innovative
         */
        return (root.val==p.val || root.val==q.val || (root.val-p.val)*(root.val-q.val)<0) ? root:
                root.val>q.val && root.val>p.val ? lowestCommonAncestor(root.left,p,q):lowestCommonAncestor(root.right,p,q);
    }

    private void trackAllParentsOfNode(TreeNode currentNode, TreeNode find, boolean isNodeP){
        if (currentNode.val == find.val) {
            if (isNodeP) parentOfp.add(currentNode);
            else if (parentOfp.contains(currentNode) && commonAncestor == null) commonAncestor = currentNode;
            return;
        }

        if (currentNode.val < find.val)
            trackAllParentsOfNode(currentNode.right, find, isNodeP);
        else
            trackAllParentsOfNode(currentNode.left, find, isNodeP);

        if (isNodeP) parentOfp.add(currentNode);
        else if (parentOfp.contains(currentNode) && commonAncestor == null) commonAncestor = currentNode;
    }
}
