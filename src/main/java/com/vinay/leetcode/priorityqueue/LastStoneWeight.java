package com.vinay.leetcode.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];
        else if (stones.length == 2) {
            return Math.abs(stones[0]-stones[1]);
        }
        Queue<Integer> queue = new PriorityQueue<>((insert, present)->present-insert);
        for (int i:stones){
            queue.add(i);
        }
        while (queue.size()>1){
            int greater = queue.remove();
            int lesser = queue.remove();
            if (greater > lesser)
                queue.add(greater-lesser);
        }
        return queue.size()>0?queue.remove():0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{5, 5}));
    }
}
