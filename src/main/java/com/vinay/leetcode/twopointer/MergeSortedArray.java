package com.vinay.leetcode.twopointer;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] num1 = new int[]{4,0,0,0,0,0};
        mergeSortedArray.merge(num1, 1, new int[]{1,2,3,5,6}, 5);
        for (int i=0;i< num1.length;i++){
            System.out.println(num1[i]);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = nums1.length-m;
        int nums2Index = 0;
        int reArrangeIndex = 0;
        pushToEnd(nums1, m);
        while (reArrangeIndex < nums1.length){
            if (nums1Index == nums1.length ){
                nums1[reArrangeIndex] = nums2[nums2Index];
                nums2Index++;
            } else if (nums2Index == nums2.length) {
                nums1[reArrangeIndex] = nums1[nums1Index];
                nums1Index++;
            }else {
                if (nums1[nums1Index] >= nums2[nums2Index]){
                    nums1[reArrangeIndex] = nums2[nums2Index];
                    nums2Index++;
                }else{
                    nums1[reArrangeIndex] = nums1[nums1Index];
                    nums1Index++;
                }
            }
            reArrangeIndex++;
        }
    }

    private int[] pushToEnd(int[] nums1, int m){
        if (nums1.length == m){
            return nums1;
        }

        int copyToIndex = nums1.length-1;
        for (int i=m-1;i>=0;i--){
            nums1[copyToIndex] = nums1[i];
            copyToIndex--;
        }

        return nums1;
    }
}
