package com.vinay.leetcode.prefix.sum;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight();
        randomPickWithWeight.init(new int[]{1,2,3,4});
    }

    int[] weight;
    public void init(int[] w) {
        weight = w;
        for (int i=1;i<weight.length;i++){
            weight[i] += weight[i-1];
        }
    }

    public int pickIndex() {
        int totalSum = weight[weight.length-1];
        Random random=new Random();
        int target=1+random.nextInt(totalSum);
        int low = 0; int high = this.weight.length-1;
        //binary search
        while(low<=high){
            int mid = low + (high-low)/2;
            if (target > this.weight[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
