package com.vinay.geeksforgeeks;

/*
https://practice.geeksforgeeks.org/problems/da62a798bca208c7a678c133569c3dc7f5b73500/1
 */
public class FlatteningALinkedList {
    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root){
        if (root == null)
            return null;
        Node current = root;
        while (current.bottom != null){
            Node temp = current;
            while (temp.next != null && temp.next.data < current.bottom.data) {
                temp = temp.next;
            }
            Node next = temp.next;
            Node bottom = current.bottom;
            if (next == null) {
                temp.next = bottom;
                bottom = null;
            }else if (next.data > bottom.data) {
                current.bottom = null;
                temp.next = bottom;
                bottom.next = next;
            }
            current = bottom;
        }
        flatten(root.next);
        return root;
    }
}
