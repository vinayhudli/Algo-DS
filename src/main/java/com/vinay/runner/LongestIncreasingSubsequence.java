package com.vinay.runner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
    public int lis(final int[] A) {
        findLargestSequence(0, 0, A, null);
        return maxLength;
    }

    int maxLength = 0;

    private void findLargestSequence(int index, int currentLength, int[] A, Integer previousElement){
        if (index == A.length){
            maxLength = Math.max(maxLength, currentLength);
            return;
        }
        if (previousElement == null || A[index] > previousElement){
            findLargestSequence(index+1, currentLength+1, A, A[index]);
        }
        findLargestSequence(index+1, currentLength, A, previousElement);
    }
}
