package com.vinay.leetcode.studyplan.questions;

public class RemoveNthNodeFromList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head,start = head, end = head;
        end = moveToNthNode(end, n);
        while (end.next!= null){
            end = end.next;
            pre = start;
            start = start.next;
        }
        if (start == head)
            return start.next;
        else{
            pre.next = start.next;
        }
        return head;
    }

    public ListNode moveToNthNode(ListNode end, int n){
        int count = 0 ;
        while (count < n){
            end = end.next;
            count++;
        }
        return end;
    }
}
