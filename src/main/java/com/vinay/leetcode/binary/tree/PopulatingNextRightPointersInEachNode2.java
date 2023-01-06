package com.vinay.leetcode.binary.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public void bfsTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            if (node == null)
                continue;
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * bfs traversed tree array to tree
     * @param arr
     * @return
     */
    public Node arrayToTree(Integer[] arr){
        if (arr.length == 0)
            return null;
        Queue<Node> treeNodes = new ArrayDeque<>();
        Node root= new Node(arr[0]);
        treeNodes.add(root);
        int index = 0;
        while (!treeNodes.isEmpty()){
            Node node = treeNodes.remove();
            if (index+1 > arr.length-1){
                break;
            }else {
                if (arr[index+1] != null){
                    node.left = new Node(arr[index+1]);
                    treeNodes.add(node.left);
                }
            }

            if (index+2 > arr.length-1){
                break;
            }else {
                if (arr[index+2] != null){
                    node.right = new Node(arr[index+2]);
                    treeNodes.add(node.right);
                }
            }
            index = index+2;
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Node current = root;
        while (current != null) {
            if (current.left != null) {
                if (current.right != null) {
                    current.left.next = current.right;
                } else {
                    Node nextRightNode = nextRightNode(current.next);
                    current.left.next = nextRightNode;
                }
            }

            if (current.right != null) {
                Node nextRightNode = nextRightNode(current.next);
                current.right.next = nextRightNode;
            }
            current = current.next;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode2 populatingNextRightPointersInEachNode2 =
                new PopulatingNextRightPointersInEachNode2();
        Node node = populatingNextRightPointersInEachNode2.arrayToTree(new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7});
        populatingNextRightPointersInEachNode2.connect(node);
    }

    private Node nextRightNode(Node node){
        if (node == null)
            return node;

        if (node.left != null)
            return node.left;
        if (node.right != null)
            return node.right;

        return nextRightNode(node.next);
    }
}
