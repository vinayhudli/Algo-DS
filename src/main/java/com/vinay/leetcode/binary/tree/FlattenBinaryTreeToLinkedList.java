package com.vinay.leetcode.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.vinay.leetcode.binary.tree.PathSum2.*;

public class FlattenBinaryTreeToLinkedList {


    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        PathSum2.TreeNode node = pathSum2.arrayToTree(new Integer[]{1,2,3,4, null,5,null,6, null, 7, null});
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
//        flattenBinaryTreeToLinkedList.flatten(node);
        pathSum2.bfsTraversal(node);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode current = root;
        TreeNode next = root.left;
        root.left = null;
        Deque<TreeNode> rightSubTree = new ArrayDeque<>();
        if (root.right != null)
            rightSubTree.push(root.right);

        while (next != null || !rightSubTree.isEmpty() ){
            if (next != null){
                current.right = next;
                current = next;
                if (current.right != null)
                    rightSubTree.push(current.right);
                next = current.left;
                current.left = null;
            }else {
                TreeNode pop = rightSubTree.pop();
                current.right = pop;
                if (pop.right != null)
                    rightSubTree.push(pop.right);
                current = pop;
                next = pop.left;
                pop.left = null;
            }
        }
    }

}
