package com.vinay.leetcode.linkedlist;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/description/
Mark the start and end of group and reverse each group
 */
public class ReverseNodesinkGroup {

     public class ListNode {

          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static void main(String[] args) {
        ReverseNodesinkGroup reverseNodesinkGroup = new ReverseNodesinkGroup();
        ListNode listNode = reverseNodesinkGroup.new ListNode();
        listNode.val = 1;
        listNode.next = reverseNodesinkGroup.new ListNode(2, reverseNodesinkGroup.new ListNode(3, reverseNodesinkGroup.new ListNode(4)));
        ListNode listNode1 = reverseNodesinkGroup.reverseKGroup(listNode, 4);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode previousGroupEnding = new ListNode();
        ListNode next = previousGroupEnding;
        previousGroupEnding.next = head;
        ListNode newHead = previousGroupEnding;
        while (next.next != null){
            next = next.next;
            count++;
            if (count == k){
                ListNode temp = next.next;
                reverseNode(previousGroupEnding.next, next);
                count = 0;
                ListNode startOfGroup = previousGroupEnding.next;
                startOfGroup.next = temp;
                previousGroupEnding.next = next;
                previousGroupEnding = startOfGroup;
                next = previousGroupEnding;
            }
        }
        return newHead.next;
    }

    private void reverseNode(ListNode start, ListNode end){
        ListNode previous = start;
        ListNode current = previous.next;
        while (previous != end){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

}
