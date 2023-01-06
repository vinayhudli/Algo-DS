package com.vinay.leetcode.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

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

    List<Integer> list = new ArrayList<>();
    int currentPos = -1;
    private void init(TreeNode node){
        if (node == null)
            return;
        init(node.left);
        list.add(node.val);
        init(node.right);
    }

    public int next() {
        currentPos++;
        return list.get(currentPos);
    }

    public boolean hasNext() {
        return currentPos < list.size() ;
    }
}
