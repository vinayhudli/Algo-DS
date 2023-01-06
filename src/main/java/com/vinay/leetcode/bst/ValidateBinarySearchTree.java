package com.vinay.leetcode.bst;

public class ValidateBinarySearchTree {
    
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

   SubTreeObj leftSubTree = new SubTreeObj();
  SubTreeObj rightSubTree = new SubTreeObj();

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = validateBinarySearchTree.new TreeNode(2147483647);
//        treeNode.right = validateBinarySearchTree.new TreeNode(4);
//        treeNode.right.left = validateBinarySearchTree.new TreeNode(3);
//        treeNode.right.right = validateBinarySearchTree.new TreeNode(6);
//        treeNode.left = validateBinarySearchTree.new TreeNode(1);
        System.out.println(validateBinarySearchTree.isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return isSubTreeValid(root).isSubTreeValid;
    }

    public SubTreeObj isSubTreeValid(TreeNode node){
        SubTreeObj currentSubtree = new SubTreeObj();
        currentSubtree.isSubTreeValid = false ;

        if (node.left != null && node.val <= node.left.val)
            return currentSubtree ;

        if (node.right != null && node.val >= node.right.val)
            return currentSubtree ;

        SubTreeObj leftSubTree ;
        if (node.left != null) {
            leftSubTree = isSubTreeValid(node.left);
            if (!leftSubTree.isSubTreeValid || node.val <= leftSubTree.highestValue)
                return currentSubtree;
        }else {
            leftSubTree = new SubTreeObj();
            leftSubTree.highestValue = node.val;
            leftSubTree.lowestValue = node.val;
        }

        SubTreeObj rightSubTree ;

        if (node.right != null) {
            rightSubTree = isSubTreeValid(node.right);
            if (!rightSubTree.isSubTreeValid || node.val >= rightSubTree.lowestValue)
                return currentSubtree;
        }else {
            rightSubTree = new SubTreeObj() ;
            rightSubTree.lowestValue = node.val;
            rightSubTree.highestValue = node.val;
        }

        currentSubtree.lowestValue = Math.min(leftSubTree.lowestValue, rightSubTree.lowestValue);
        currentSubtree.lowestValue = Math.min(currentSubtree.lowestValue, node.val);
        currentSubtree.highestValue = Math.max(leftSubTree.highestValue, rightSubTree.highestValue);
        currentSubtree.highestValue = Math.max(currentSubtree.highestValue, node.val);
        currentSubtree.isSubTreeValid = true ;


        return currentSubtree;
    }

    public class SubTreeObj{
        boolean isSubTreeValid = true;
        Integer lowestValue = null;
        Integer highestValue = null;

    }

}
