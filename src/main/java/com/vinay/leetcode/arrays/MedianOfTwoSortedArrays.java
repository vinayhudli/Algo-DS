package com.vinay.leetcode.arrays;

public class MedianOfTwoSortedArrays {

//    https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/1823043/Python-O(log(min(m-n)))-Time-Complexity-w-Comments
    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        int low = 0;
        int high = nums1Length;
        int index2 ;
        while (low < high){
//            make sure mid and index2 together form lower half of the combined array
            int mid = (low+high)/2;
            index2 = (nums1Length+nums2Length-1)/2 - mid;

            if (nums1[mid] > nums2[index2])
                high = mid;
            else
                low = mid+1;
        }
        index2 = (nums1Length+nums2Length-1)/2 - low;

        int smaller ;
        if (index2<0)
            smaller = nums1[low-1];
        else if (low-1 < 0)
            smaller = nums2[index2];
        else
            smaller = Math.max(nums2[index2], nums1[low-1]);

        if ((nums1Length+nums2Length)%2 == 1)
            return smaller;

        int larger ;
        if (index2+1>=nums2Length)
            larger = nums1[low];
        else if (low>=nums1Length)
            larger = nums2[index2+1];
        else
            larger = Math.min(nums2[index2+1], nums1[low]);

        return (smaller+larger)/(double)2;
    }
}
