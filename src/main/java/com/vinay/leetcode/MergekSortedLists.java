package com.vinay.leetcode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {

    public static void main(String[] args) {
        MergekSortedLists mergekSortedLists = new MergekSortedLists();
        ListNode[] listNodeList = mergekSortedLists.getListNodeList(new int[][]{{1,4,5}, {1,3,4}, {2,6}});
        ListNode listNode = mergekSortedLists.mergeKLists(listNodeList);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private ListNode[] getListNodeList(int[][] list){
        ListNode[] listNodes = new ListNode[list.length];
        for (int i=0;i< list.length;i++){
            listNodes[i] = new ListNode();
            ListNode listNode = listNodes[i];
            for (int j=0;j<list[i].length;j++){
                listNode.next = new ListNode();
                listNode.next.val = list[i][j];
                listNode = listNode.next;
            }
            listNodes[i] = listNodes[i].next;
        }
        return listNodes;
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode start = result;
        int numberOfEnds = 0;
        while (numberOfEnds < lists.length){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            numberOfEnds = 0;
            for (int i=0;i < lists.length; i++ ){
                ListNode listNode = lists[i];
                if (listNode==null) {
                    numberOfEnds++;
                    continue;
                }
                if (listNode.val<=min){
                    minIndex = i;
                    min = listNode.val;
                }
            }

            if (minIndex>-1){
                result.next = new ListNode();
                result.next.val = lists[minIndex].val;
//                System.out.println("minindex:" + minIndex+" val: "+lists[minIndex].val);
                result = result.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return start.next;
    }
}
