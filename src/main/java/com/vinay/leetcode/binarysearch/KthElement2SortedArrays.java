package com.vinay.leetcode.binarysearch;

/**
 * https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
public class KthElement2SortedArrays {

    private int kthElement(int[] a, int[] b, int k){
        return binarySearch(a, b, 0, a.length-1, 0, b.length-1, k);
    }

    private int binarySearch(int[] a, int[] b, int l1, int r1, int l2, int r2, int k){
//        base case
        if (l1>r1)
            return b[l2+k-1];
        else if (l2>r2)
            return a[l1+k-1];

//        general case
        int m1 = l1+(r1-l1)/2;
        int m2 = l2+(r2-l2)/2;

        int kc = (m1-l1+1)+(m2-l2+1);

        if (kc <= k){
            if (a[m1] < b[m2]){
                return binarySearch(a, b, m1+1, r1, l2, r2, k-(m1-l1+1));
            }else {
                return binarySearch(a,b,l1,r1,m2+1,r2,k-(m2-l2+1));
            }
        }else{
            if (a[m1] < b[m2]){
                return binarySearch(a,b,l1,r1,l2,m2-1,k);
            }else {
                return binarySearch(a,b,l1,m1-1,l2,r2,k);
            }
        }
    }
}
