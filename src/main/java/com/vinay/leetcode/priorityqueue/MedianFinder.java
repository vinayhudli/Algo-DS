package com.vinay.leetcode.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/find-median-from-data-stream/submissions/
 */
public class MedianFinder {

    Queue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> upperHalf = new PriorityQueue<>();
    boolean even = true;
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (even) {
            upperHalf.add(num);
            lowerHalf.add(upperHalf.poll());
        }else {
            lowerHalf.add(num);
            upperHalf.add(lowerHalf.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return ((double) lowerHalf.peek()+upperHalf.peek())/2;
        return lowerHalf.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
