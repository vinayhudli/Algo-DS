package com.vinay.leetcode.binarysearch;

import java.util.Arrays;

/*
https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int lowestHour = 0;
        while (low<=high){
            int mid = (low+high)/2;
            if (isValid(piles, mid, h)){
                lowestHour = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return lowestHour;
    }

    private boolean isValid(int[] piles, int hours, int target){
        long totalTime = 0;
        for (int i=0;i< piles.length;i++){
            int quotient = piles[i]/hours;
            if (piles[i]%hours != 0)
                quotient++;
            totalTime += quotient;
        }
        return totalTime<=target;
    }

}
