package com.vinay.leetcode.linkedlist;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        ListNode next = current.next;
        ListNode newHead = next;
        while (next != null){
            ListNode temp = current;
            current.next = next.next;
            next.next = current;

            current = current.next;
            next = null;
            if (current != null)
                next = current.next;

            if (next != null)
                temp.next = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = swapNodesInPairs.new ListNode(1);
        ListNode head = listNode;
        listNode.next = swapNodesInPairs.new ListNode(2);
        listNode.next.next = swapNodesInPairs.new ListNode(3);
        listNode.next.next.next = swapNodesInPairs.new ListNode(4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        ListNode listNode1 = swapNodesInPairs.swapPairs(head);


        System.out.println();
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
