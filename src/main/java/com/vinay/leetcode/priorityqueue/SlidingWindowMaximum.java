package com.vinay.leetcode.priorityqueue;

import java.util.*;

/*
https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 8);
        for (int i:ints)
            System.out.println(i);
    }

    public int[] maxSlidingWindowMyApproach(int[] nums, int k) {
        if (k == 1)
            return nums;
        if (k == nums.length)
            return new int[]{findMax(nums)};

        int adder = 10000;
        int[] numToOccurence = new int[20001];
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<k;i++){
            queue.add(nums[i]);
            numToOccurence[nums[i]+adder]++;
        }
        int[] max = new int[nums.length-k+1];
        for (int i=k;i< nums.length;i++){
            Integer peek = queue.peek();
            while (numToOccurence[peek+adder]==0){
                queue.poll();
                peek = queue.peek();
            }
            numToOccurence[nums[i-k]+adder]--;
            max[i-k] = peek;

            queue.add(nums[i]);
            numToOccurence[nums[i]+adder]++;
        }
        Integer peek = queue.peek();
        while (numToOccurence[peek+adder]==0){
            queue.poll();
            peek = queue.peek();
        }
        max[nums.length-k] = peek;
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int[] result = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> dequeue = new ArrayDeque<>(k+1);
        for (int i=0;i< nums.length;i++){
            while (!dequeue.isEmpty() && dequeue.peek()+k<=i)
                dequeue.poll();
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()]<=nums[i])
                dequeue.pollLast();
            dequeue.add(i);
            if (i>=k-1)
                result[index++] = nums[dequeue.peek()];
        }
        return result;
    }

    private int findMax(int[] nums){
        int max = nums[0];
        for (int i=1;i< nums.length;i++)
            max = Math.max(max, nums[i]);

        return max;
    }
}
