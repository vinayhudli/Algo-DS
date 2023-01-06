package com.vinay.leetcode.prefix.sum;

import java.util.Arrays;

public class RemovingMinimumNumberOfMagicBeans {

    public static void main(String[] args) {
        RemovingMinimumNumberOfMagicBeans removingMinimumNumberOfMagicBeans = new RemovingMinimumNumberOfMagicBeans();
        long test = (long)100000*100000;
        System.out.println(test);
//        System.out.println(removingMinimumNumberOfMagicBeans.minimumRemoval(new int[]{2}));
    }

    /**
     * Logic is to make everything 0 below i and everything equal >= i , keep doing this while decreasing value of i
     * @param beans
     * @return
     */
    public long minimumRemoval(int[] beans) {
        if (beans.length==1)
            return 0;
        Arrays.sort(beans);
        long[] sum = new long[beans.length];
        sum[0] = beans[0];
        for (int i=1;i< beans.length;i++){
            sum[i] = sum[i-1] + beans[i];
        }

        long minimumRemoves = sum[sum.length-2];
        long previousRemovesMatch = 0;
        for (int i= sum.length-2;i>=0;i--){
            previousRemovesMatch += ((long)beans[i+1]-beans[i])*(sum.length-i-1);
            long totalSum = i-1>=0?sum[i-1] :0;
            if (previousRemovesMatch >= minimumRemoves)
                break;
            minimumRemoves = Math.min(minimumRemoves, previousRemovesMatch+totalSum);
        }
        return minimumRemoves;
    }
}
