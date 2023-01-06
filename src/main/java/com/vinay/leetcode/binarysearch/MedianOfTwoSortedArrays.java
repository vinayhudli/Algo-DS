package com.vinay.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.getMedianBasedOnSplitting(new int[]{1}, new int[]{2,3,4,5,6}));
    }

    private int getMedian(int[] a, int[] b){
        return 0;
    }

    /**
     * https://www.youtube.com/watch?v=yD7wV8SyPrc&ab_channel=KeertiPurswani
     * @param a
     * @param b
     * I added all the edge cases by myself so good job, the methodology was borrowed from the video
     * @return
     */
    private double getMedianBasedOnSplitting(int[] a, int[] b){
        if (a.length<b.length)
            return getMedianBasedOnSplitting(b,a);

        if (b.length == 0){
            int mid = (a.length-1)/2;
            double median = a[mid];
            if ((a.length-1)%2!=0){
                median = (median+a[mid+1])/2;
            }
            return median;
        }
        int medianIndex = (a.length+b.length-1)/2;
        int low = 0;
        int high = a.length-1;
        int m1 =Integer.MIN_VALUE,m2=Integer.MIN_VALUE;
        while (low<=high){
            m1 = (low+high)/2;
            m2 = medianIndex - 1 - m1;
            System.out.println("m1:"+m1+" m2:"+m2);
            if (m1 > medianIndex) {
                high = m1-1;
            } else if (m2>=b.length) {
                low = m1+1;
            } else if ((m2+1)<b.length && m1 >= 0 && a[m1]>b[m2+1]){
                high = m1-1;
            }else if ((m1+1)<a.length && m2 >=0 && b[m2]>a[m1+1]) {
                low = m1+1;
            }else
                break;
        }

        System.out.println("low : "+low+" high : "+high+" mid1 : "+m1+" mid2 :"+m2);

        if (low>high) {
            m2 = medianIndex;
            m1 = -1;
        }
        int leftOfA = m1>=0 && m1<a.length?a[m1]:Integer.MIN_VALUE;
        int leftOfB = m2>=0 && m2<b.length?b[m2]:Integer.MIN_VALUE;
        int left = Math.max(leftOfA, leftOfB);
        double median = left;
        if((a.length+b.length-1)%2 != 0){
            m1++;
            int rightOfA = m1>=0 && m1<a.length?a[m1]:Integer.MAX_VALUE;
            m2++;
            int rightOfB = m2>=0 && m2<b.length?b[m2]:Integer.MAX_VALUE;
            int right = Math.min(rightOfA, rightOfB);
            System.out.println("median : "+median+" rightofA : "+rightOfA+" rightofB : "+rightOfB);
            median = (median+right)/2;
        }
        return median;
    }
}
