package com.vinay.leetcode.bst;

import com.vinay.leetcode.binary.tree.PathSum2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConvertSortedListToBinarySearchTree {

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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null){
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        return constructChildNode(list, 0, list.size()-1);
    }

    private TreeNode constructChildNode(List<ListNode> nums, int start, int end){
        if (start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums.get(mid).val);
        node.left = constructChildNode(nums, start, mid-1);
        node.right = constructChildNode(nums, mid+1, end);
        return node;
    }

    /**
     * bfs traversed tree array to tree
     * @param arr
     * @return
     */
    public TreeNode arrayToTree(Integer[] arr){
        if (arr.length == 0)
            return null;
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        TreeNode root= new TreeNode(arr[0]);
        treeNodes.add(root);
        int index = 0;
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.remove();
            if (index+1 > arr.length-1){
                break;
            }else {
                if (arr[index+1] != null){
                    node.left = new TreeNode(arr[index+1]);
                    treeNodes.add(node.left);
                }
            }

            if (index+2 > arr.length-1){
                break;
            }else {
                if (arr[index+2] != null){
                    node.right = new TreeNode(arr[index+2]);
                    treeNodes.add(node.right);
                }
            }
            index = index+2;
        }

        return root;
    }
}
