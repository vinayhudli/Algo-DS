package com.vinay.leetcode;

import java.util.*;

public class UniqueBinarySearchTreesII {
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
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        List<TreeNode> treeNodes = uniqueBinarySearchTreesII.generateTrees(1);
        uniqueBinarySearchTreesII.printResult(treeNodes);

    }

    public void printResult(List<TreeNode> list){
        Queue<TreeNode> queue = new ArrayDeque<>();
        for (TreeNode entry: list){
            queue.add(entry);
            System.out.println("tree ");
            while (!queue.isEmpty()){
                TreeNode remove = queue.remove();
                System.out.print(remove.val+", ");

                if (remove.left != null)
                    queue.add(remove.left);

                if (remove.right!=null)
                    queue.add(remove.right);
            }
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateSubTrees(1,n);
    }

    public List<TreeNode> generateSubTrees(int startVal, int endVal){
        if (startVal > endVal){
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }

        if (startVal == endVal){
            List<TreeNode> result = new ArrayList<>();
            result.add(new TreeNode(startVal));
            return result;
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i=startVal;i<=endVal;i++){
            List<TreeNode> leftSubTree = generateSubTrees(startVal, i - 1);
            List<TreeNode> rightSubTree = generateSubTrees(i + 1, endVal);
            for (TreeNode leftTree:leftSubTree){
                for (TreeNode rightTree:rightSubTree){
                    TreeNode root = new TreeNode(i, leftTree, rightTree);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
