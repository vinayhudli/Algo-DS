package com.vinay.leetcode.studyplan.questions;

public class MiddleOfLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode oneJumpPointer = head;
        ListNode twoJumpPointer = head;

        while (twoJumpPointer != null){
            if (twoJumpPointer.next != null){
                twoJumpPointer = twoJumpPointer.next.next;
            }else {
                return oneJumpPointer;
            }

            oneJumpPointer = oneJumpPointer.next;
        }
        return oneJumpPointer;
    }
}
