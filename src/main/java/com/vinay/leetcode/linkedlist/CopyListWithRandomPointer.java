package com.vinay.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomListMySoln(Node head) {
        if (head == null)
            return null;

        Node node = head;
        Node first = new Node(head.val);
        Map<Node, Node> oldToNewMap = new HashMap<>();
        oldToNewMap.put(head, first);
        while (node != null){
            Node newNode = oldToNewMap.get(node);
            if (node.next != null){
                oldToNewMap.computeIfAbsent(node.next, k->new Node(k.val));
                newNode.next = oldToNewMap.get(node.next);
            }
            if (node.random != null){
                oldToNewMap.computeIfAbsent(node.random, k->new Node(k.val));
                newNode.random = oldToNewMap.get(node.random);
            }
            node = node.next;
        }
        return first;
    }

//    Based on the most common solutions from discussion: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node node = head;
        while (node!= null){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }

        node = head;
        while (node!= null){
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }

        node = head;
        Node first = head.next;
        Node newNode = first;
        while (newNode.next != null){
            node.next = newNode.next;
            newNode.next = newNode.next.next;
            newNode = newNode.next;
            node = node.next;
        }
        node.next = null;
        return first;
    }
}
