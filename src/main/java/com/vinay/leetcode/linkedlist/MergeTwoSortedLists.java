package com.vinay.leetcode.linkedlist;

public class MergeTwoSortedLists {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
//        ListNode list1 = mergeTwoSortedLists.new ListNode(1);
//        list1.next = mergeTwoSortedLists.new ListNode(2);
//        list1.next.next = mergeTwoSortedLists.new ListNode(4);
        ListNode list2 = mergeTwoSortedLists.new ListNode(1);
//        list2.next = mergeTwoSortedLists.new ListNode(3);
//        list2.next.next = mergeTwoSortedLists.new ListNode(4);
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(list2, null);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode startNode = new ListNode();
        ListNode result = startNode;

        while (list1 != null || list2 != null){
            if (list2 == null || (list1 != null && list1.val < list2.val)){
                result.next = list1;
                list1 = list1.next;
            }else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        return startNode.next;
    }
}
