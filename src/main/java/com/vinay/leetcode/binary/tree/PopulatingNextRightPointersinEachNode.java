package com.vinay.leetcode.binary.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

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

    public Node connect(Node root) {
        if (root == null)
            return null ;
        Queue<Node> parent = new ArrayDeque<>();
        Queue<Node> child = new ArrayDeque<>();
        parent.add(root);
        while (!parent.isEmpty() || !child.isEmpty()){
            Node remove = parent.remove();
            if (remove.left != null)
                child.add(remove.left);
            if (remove.right != null)
                child.add(remove.right);
            if (parent.isEmpty()){
                parent = child;
                child = new ArrayDeque<>();
            }else{
                remove.next = parent.peek();
            }
        }
        return root;
    }

    /**
     * this is brilliant solution, connect everything on left subtree and link between left and right subtree,
     * then connect everything in right subtree
     * @param root
     * @return
     */
    public Node connectRecursive(Node root){
        if(root==null)
            return root;

        if(root.left!=null)
            root.left.next=root.right;
        if(root.right!=null && root.next!=null)
            root.right.next=root.next.left;

        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }



}
