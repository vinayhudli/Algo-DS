package com.vinay.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    int area = 0;

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,4}));
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> list = new ArrayDeque<>();
        for (int i=0;i< heights.length;i++){
            while (!list.isEmpty() && heights[list.peekLast()] > heights[i]){
                Integer removeLast = list.removeLast();
                area = Math.max(area, (i-removeLast)*heights[removeLast]);
                System.out.println("i "+i+" removelast "+removeLast);
            }
            list.add(i);
        }

        while (!list.isEmpty()){
            Integer removeFirst = list.removeFirst();
            Integer peekLast = list.peekLast();
            System.out.println("removefirst "+removeFirst+" peeklast "+peekLast);
            if (peekLast != null)
                area = Math.max(area, (peekLast-removeFirst+1)*heights[removeFirst]);
        }
        return area;
    }

    private void calculateAreaFromTail(Deque<Integer> queue, int[] heights, int currentIndex){

    }
}
