package com.vinay.leetcode.prefix.sum;

public class RangeSumQueryImmutable {
    int[] sum ;
    int[] nums ;

    public static void main(String[] args) {
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable();
        rangeSumQueryImmutable.init(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable.sumRange(5,5));
    }

    public void init(int[] nums){
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1;i< nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int leftSum = 0 ;
        if (left > 0){
            leftSum = sum[left-1];
        }
        return sum[right]-leftSum;
    }

}
