package com.vinay.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 */
public class Median {
    int medianLowIndex = -1 ;
    int medianHighIndex = -1 ;
    int num1LowIndex = 0;
    int num1HighIndex = 0;
    int num2LowIndex = 0;
    int num2HighIndex = 0;
    int currentSortedResultIndex = -1;
    int[] num1;
    int[] num2;

    public static void main(String[] args) {
        Median median = new Median();
        median.num1 = new int[]{1,3};
        median.num2 = new int[]{2};
        median.num1HighIndex = median.num1.length-1;
        median.num2HighIndex = median.num2.length-1;
        while (median.medianLowIndex <0 || median.medianHighIndex < 0){

        }
    }

    public void getPartialSortedResult(int num1Low, int num1High, int num2Low, int num2High){
        int num1mid = (num1Low+num1High)/2;
        int num2mid = (num2High+num2Low)/2;
        if (num1mid==num1Low){
            if (num1[num1mid] < num2[num2mid]){
                currentSortedResultIndex++;
            }else {
                currentSortedResultIndex += num2mid-num2Low+1;
            }
        }
        if (num1[num1mid] < num2[num2mid]){
            getPartialSortedResult(num1Low, num1High, num2Low, num2mid-1);
        }else{
            getPartialSortedResult(num1Low, num1mid-1, num2Low, num2High);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;

    }

    public double getMedian(int[] nums1, int[] nums2){
        return 0 ;
    }
}
