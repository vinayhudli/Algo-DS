package com.vinay.runner;

public class ApplicationRunner {

    public static int Var1 ;
    public static void main(String[] args) throws InterruptedException {
        ApplicationRunner applicationRunner = new ApplicationRunner();
        System.out.println(applicationRunner.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int median = (nums1.length+ nums2.length-1)/2;
        int nums1Low = 0;
        int nums1High = nums1.length-1;
        int nums1Mid = -1;
        while (nums1Low <= nums1High){
            nums1Mid = (nums1Low+nums1High)/2;
            int nums2Indx = median-nums1Mid;
            if (nums1Mid > median){
                nums1High = nums1Mid-1;
            } else if (nums2Indx >= nums2.length) {
                nums1Low = nums1Mid+1;
            } else if (nums2Indx >= 0 && nums1[nums1Mid] <= nums2[nums2Indx]) {
                nums1Low = nums1Mid+1;
            } else{
                nums1High = nums1Mid-1;
            }
        }
        int num2Idx = median-nums1Mid;
        double result ;
        if (num2Idx >= nums2.length || nums1[nums1Mid]<=nums2[num2Idx]){
            result = nums1[nums1Mid];
            if ((nums1.length+nums2.length-1)%2 == 0)
                return result;
            if (num2Idx >= nums2.length)
                result += nums1[nums1Mid+1];
            else if (nums1Mid < nums1.length-1)
                result += Math.min(nums1[nums1Mid+1], nums2[num2Idx]);
            else
                result += nums2[num2Idx];
        }else{
            result = nums2[num2Idx];
            if ((nums1.length+nums2.length-1)%2 == 0)
                return result;
            if (num2Idx < nums2.length-1)
                result += Math.min(nums1[nums1Mid], nums2[num2Idx+1]);
            else
                result += nums1[nums1Mid];
        }
        return result/2;
    }
}
