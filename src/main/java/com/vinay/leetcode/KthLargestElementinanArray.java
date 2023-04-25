package com.vinay.leetcode;

import javax.management.Query;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];

//        Queue<Integer> queue = new PriorityQueue<>()
    }
}
