package com.vinay.leetcode.bst;

/**
 * Please review again, got this solution from gfg.
 * The main trick is inorder traversal of BST results in traversing nodes in sorted (ascending) order.
 */
public class RecoverBinarySearchTree {

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

//     public class SubTree{
//         TreeNode smallest;
//         TreeNode largest;
//     }
//
//     List<TreeNode> nodesToExchange = new ArrayList<>();
//     boolean nodeFound = false ;

    public static void main(String[] args) {
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        TreeNode root = recoverBinarySearchTree.new TreeNode(1);
        root.left = recoverBinarySearchTree.new TreeNode(3);
        root.left.right = recoverBinarySearchTree.new TreeNode(2);
        recoverBinarySearchTree.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        TreeNode swapNode = last;
        if (last == null){
            swapNode = middle;
        }
        int temp = first.val;
        first.val = swapNode.val;
        swapNode.val = temp;
    }

    TreeNode previous, first, middle, last;

    public void inorderTraversal(TreeNode node){
        if (node == null)
            return;

        inorderTraversal(node.left);
        if (previous != null && previous.val > node.val ){
            if (first == null){
                first = previous;
                middle = node;
            }else
                last = node;
        }
        previous = node;
        inorderTraversal(node.right);
    }

//    public SubTree populateNodesToBeSwapped(TreeNode node){
//        if (node == null || nodeFound) {
//            return null;
//        }
//
//        SubTree leftSubTree = populateNodesToBeSwapped(node.left);
//        SubTree rightSubTree = populateNodesToBeSwapped(node.right);
//
//        if (leftSubTree != null && node.val <= leftSubTree.largest.val){
//            nodeFound = true;
//            nodesToExchange.add(leftSubTree.largest);
//            nodesToExchange.add(node);
//            return null;
//        }else if (rightSubTree != null && node.val >= rightSubTree.smallest.val){
//            nodeFound = true;
//            nodesToExchange.add(rightSubTree.smallest);
//            nodesToExchange.add(node);
//            return null;
//        }
//
//        if (nodeFound)
//            return null;
//
//        SubTree subTree = new SubTree();
//
//        if (leftSubTree == null)
//            subTree.smallest = node;
//        else
//            subTree.smallest =  leftSubTree.smallest  ;
//
//        subTree.largest = rightSubTree != null ? rightSubTree.largest : node ;
//
//        return subTree;
//    }

}
