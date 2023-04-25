package com.vinay.leetcode.priorityqueue;

import javax.management.Query;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/


 */
public class KthLargestElementinaStream {
    Queue<Integer> queue = new PriorityQueue<>((inserted, present)->present-inserted);
    int k;
    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        for (int i=0; i< nums.length;i++){
            queue.add(nums[i]);
        }
        System.out.println("queue elements");
        for (Integer e:queue){
            System.out.println(e);
        }
        System.out.println("---");
    }

    public int add(int val) {
        queue.add(val);
        int i=0;
        for (Integer e:queue){
//            System.out.println(e);
            if (i == k-1)
                return e;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        KthLargestElementinaStream kthLargestElementinaStream = new KthLargestElementinaStream(3, new int[]{4,5,8,2});
        System.out.println(kthLargestElementinaStream.add(3));
        System.out.println(kthLargestElementinaStream.add(5));
        System.out.println(kthLargestElementinaStream.add(10));
        System.out.println(kthLargestElementinaStream.add(9));
        System.out.println(kthLargestElementinaStream.add(4));
    }

}
